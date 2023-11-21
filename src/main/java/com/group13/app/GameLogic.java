package com.group13.app;

import java.util.Arrays;

public abstract class GameLogic {

  final BoardSpace[] boardSpaces = {
      new PassiveSpace("Start", "You passed the start!"),
      new PropertySpace(
          "Burgerbar",
          "You've passed the Burgerbar!",
          1,
          Color.GREEN),
      new PropertySpace(
          "Pizzariaet",
          "You've passed the Pizzaria!",
          1,
          Color.GREEN),
      new ChanceSpace("Chance", "You've passed the Chance!"),
      new PropertySpace(
          "Slikbutikken",
          "You've passed the Slikbutik!",
          1,
          Color.LIGHT_BLUE),
      new PropertySpace(
          "Iskiosken",
          "You've passed the Iskiosk!",
          1,
          Color.LIGHT_BLUE),
      new PassiveSpace("Fængselsbesøg", "You've passed the På besøg i fængsel!"),
      new PropertySpace("Museet", "You've passed the Museum!", 2, Color.PINK),
      new PropertySpace(
          "Biblioteket",
          "You've passed the Bibliotek!",
          2,
          Color.PINK),
      new ChanceSpace("Chance", "You've passed the Chance!"),
      new PropertySpace(
          "Skaterparken",
          "You've passed the Skaterpark!",
          2,
          Color.ORANGE),
      new PropertySpace("Poolen", "You've passed the Pool!", 2, Color.ORANGE),
      new PassiveSpace("Gratis parkering", "You've passed the Gratis parkering!"),
      new PropertySpace(
          "Spillehallen",
          "You've passed the Spillehal!",
          3,
          Color.RED),
      new PropertySpace("Biografen", "You've passed the Biograf!", 3, Color.RED),
      new ChanceSpace("Chance", "You've passed the Chance!"),
      new PropertySpace(
          "Legetøjsbutikken",
          "You've passed the Legetøjsbutik!",
          3,
          Color.YELLOW),
      new PropertySpace(
          "Dyrehandler",
          "You've passed the Dyrehandler!",
          3,
          Color.YELLOW),
      new JailSpace("Fængsel", "You've passed the Fængsel!"),
      new PropertySpace(
          "Bowlinghallen",
          "You've passed the Bowlinghal!",
          4,
          Color.GREEN),
      new PropertySpace("Zoo", "You've passed the Zoo!", 4, Color.GREEN),
      new ChanceSpace("Chance", "You've passed the Chance!"),
      new PropertySpace(
          "Vandland",
          "You've passed the Vandland!",
          5,
          Color.DARK_BLUE),
      new PropertySpace(
          "Strandpromenaden",
          "You've passed the Strandpromenaden!",
          5,
          Color.DARK_BLUE),
  };
  protected Player[] players;
  protected int turn;
  protected Dice dice;
  protected Bank bank;
  protected boolean isPlaying;
  // private ChanceCards chanceCards;
  private final int JAIL_PENALTY = 1;
  private final int PASS_START_REWARD = 2;

  public GameLogic() {
    turn = 0;
    dice = new Dice(6);
    bank = new Bank(90);
    isPlaying = true;
    initPlayers();
    // chanceCards = new ChanceCards();
    // order players by age
  }

  protected abstract void initPlayers();

  protected abstract void displayMessage(String message);

  private String usedGetOutOfJailFree(Player player) {
    return String.format("The player %s used a get out of jail free card and now has %d get out of jail cards left",
        player.getName(),
        player.getOutOfJailFree);
  }

  private String paidJail(Player player, BoardSpace space) {
    return String.format("The player %s paid the jail %d M and now has %d M left",
        player.getName(),
        JAIL_PENALTY,
        player.account.getBalance());
  }

  protected String wentBankrupt(Player player, BoardSpace space) {
    try {
      return String.format(
          "The player %s went bankrupt when attempting to pay %d M on %s",
          player.getName(),
          space.getPrice(),
          space.getName());
    } catch (Exception e) {
      return e.toString();
    }
  }

  protected String boughtProperty(Player player, BoardSpace space) {
    try {
      return String.format(
          "The player %s bought the property %s for %d M and now has %d M left",
          player.getName(),
          space.getName(),
          space.getPrice(),
          player.account.getBalance());
    } catch (Exception e) {
      return e.toString();
    }
  }

  protected String paidRentToProperty(Player player, BoardSpace space) {
    try {
      return String.format(
          "The player %s paid %d M in rent on the space %s and now has %d M left",
          player.getName(),
          space.getPrice(),
          space.getName(),
          player.account.getBalance());
    } catch (Exception e) {
      return e.toString();
    }
  }

  protected String playerRolled(Player player, BoardSpace space) {
    return String.format("The player %s rolled a %d and landed on position %d, %s",
        players[turn].getName(),
        dice.getValue(),
        players[turn].getPosition(),
        space.getName());
  }

  protected String playerPassedStart(Player player) {
    return String.format("The player %s passed the start and recieved %d M and now has %d M",
        players[turn].getName(),
        PASS_START_REWARD,
        players[turn].account.getBalance());
  }

  protected String winnerIs(Player player) {
    return String.format("The winner is %s who had %d M left",
        players[turn].getName(),
        players[turn].account.getBalance());
  }

  public void stopGame(BoardSpace space) {
    players[turn].isBankrupt = true;
    displayMessage(wentBankrupt(players[turn], space));
    isPlaying = false;
    displayMessage(getWinners());

  }

  public void playerRollDice() {
    dice.rollDice();
    if (players[turn].getPosition() + dice.getValue() >= boardSpaces.length) {
      bank.giveMoney(players[turn], PASS_START_REWARD);
      displayMessage(playerPassedStart(players[turn]));
    }
    var newPosition = (players[turn].getPosition() + dice.getValue()) % boardSpaces.length;
    players[turn].setPosition(newPosition);

    var space = boardSpaces[newPosition];
    displayMessage(playerRolled(players[turn], space));

    if (space instanceof PropertySpace) {
      try {
        if (space.getOwner() != players[turn]) {
          if (space.getOwner() == null) {
            var paidBank = bank.takeMoney(players[turn], space.getPrice());
            if (!paidBank) {
              stopGame(space);
              return;
            }
            space.setOwner(players[turn]);
            displayMessage(boughtProperty(players[turn], space));
          } else {
            var paidPlayer = players[turn].giveMoney(space.getOwner(), space.getPrice());
            if (!paidPlayer) {
              stopGame(space);
              return;
            }
            displayMessage(paidRentToProperty(players[turn], space));
          }
        }
      } catch (Exception e) {
        System.out.println(e.toString());
      }
    } else if (space instanceof JailSpace) {
      players[turn].setPosition(6);
      if (players[turn].getOutOfJailFree > 0) {
        players[turn].getOutOfJailFree--;
        displayMessage(usedGetOutOfJailFree(players[turn]));
      } else {
        bank.takeMoney(players[turn], JAIL_PENALTY);
        displayMessage(paidJail(players[turn], space));
      }
    } else if (space instanceof ChanceSpace) {
      // TODO pick chance card
    } else if (space instanceof PassiveSpace) {

    } else {
      System.out.println("Error: space type not recognized");
    }

    switchTurn();
  }

  public void switchTurn() {
    this.turn = (this.turn + 1) % this.players.length;
  }

  private void sortPlayersByBalance() {
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (var i = 0; i < players.length - 1; i++) {
        if (players[i].account.getBalance() < players[i + 1].account.getBalance()) {
          var temp = players[i];
          players[i] = players[i + 1];
          players[i + 1] = temp;
          sorted = false;
        }
      }
    }
  }

  public void sortPlayersByAge() {
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (var i = 0; i < players.length - 1; i++) {
        if (players[i].getAge() > players[i + 1].getAge()) {
          var temp = players[i];
          players[i] = players[i + 1];
          players[i + 1] = temp;
          sorted = false;
        }
      }
    }
  }

  public String getWinners() {
    sortPlayersByBalance();
    var winners = "";
    for (var i = 0; i < players.length; i++) {
      winners += (i + 1) + ": " + players[i].toString() + System.lineSeparator();
    }
    return winners;
  }
}
