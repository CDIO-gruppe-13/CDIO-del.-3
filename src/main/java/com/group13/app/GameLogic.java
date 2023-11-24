package com.group13.app;

public abstract class GameLogic {

  final BoardSpace[] boardSpaces = {
    new PassiveSpace("Start", "You passed the start!"),
    new PropertySpace(
      "Burgerbar",
      "You've passed the Burgerbar!",
      1,
      Color.GREEN
    ),
    new PropertySpace(
      "Pizzariaet",
      "You've passed the Pizzaria!",
      1,
      Color.GREEN
    ),
    new ChanceSpace("Chance", "You've passed the Chance!"),
    new PropertySpace(
      "Slikbutikken",
      "You've passed the Slikbutik!",
      1,
      Color.LIGHT_BLUE
    ),
    new PropertySpace(
      "Iskiosken",
      "You've passed the Iskiosk!",
      1,
      Color.LIGHT_BLUE
    ),
    new PassiveSpace("Fængselsbesøg", "You've passed the På besøg i fængsel!"),
    new PropertySpace("Museet", "You've passed the Museum!", 2, Color.PINK),
    new PropertySpace(
      "Biblioteket",
      "You've passed the Bibliotek!",
      2,
      Color.PINK
    ),
    new ChanceSpace("Chance", "You've passed the Chance!"),
    new PropertySpace(
      "Skaterparken",
      "You've passed the Skaterpark!",
      2,
      Color.ORANGE
    ),
    new PropertySpace("Poolen", "You've passed the Pool!", 2, Color.ORANGE),
    new PassiveSpace("Gratis parkering", "You've passed the Gratis parkering!"),
    new PropertySpace(
      "Spillehallen",
      "You've passed the Spillehal!",
      3,
      Color.RED
    ),
    new PropertySpace("Biografen", "You've passed the Biograf!", 3, Color.RED),
    new ChanceSpace("Chance", "You've passed the Chance!"),
    new PropertySpace(
      "Legetøjsbutikken",
      "You've passed the Legetøjsbutik!",
      3,
      Color.YELLOW
    ),
    new PropertySpace(
      "Dyrehandler",
      "You've passed the Dyrehandler!",
      3,
      Color.YELLOW
    ),
    new JailSpace("Fængsel", "You've passed the Fængsel!"),
    new PropertySpace(
      "Bowlinghallen",
      "You've passed the Bowlinghal!",
      4,
      Color.GREEN
    ),
    new PropertySpace("Zoo", "You've passed the Zoo!", 4, Color.GREEN),
    new ChanceSpace("Chance", "You've passed the Chance!"),
    new PropertySpace(
      "Vandland",
      "You've passed the Vandland!",
      5,
      Color.DARK_BLUE
    ),
    new PropertySpace(
      "Strandpromenaden",
      "You've passed the Strandpromenaden!",
      5,
      Color.DARK_BLUE
    ),
  };
  protected Player[] players;
  protected int turn;
  protected Dice dice;
  protected Bank bank;
  protected boolean isPlaying;
  private ChanceCards chanceCards;
  private final int JAIL_PENALTY = 1;
  private final int PASS_START_REWARD = 2;

  public GameLogic() {
    turn = 0;
    dice = new Dice(6);
    bank = new Bank(90);
    isPlaying = true;
    chanceCards = new ChanceCards();
  }

  private String usedGetOutOfJailFree(Player player) {
    return String.format(
      "The player %s used a get out of jail free card and now has %d get out of jail cards left",
      player.getName(),
      player.getOutOfJailFree
    );
  }

  private String paidJail(Player player, BoardSpace space) {
    return String.format(
      "The player %s paid the jail %d M and now has %d M left",
      player.getName(),
      JAIL_PENALTY,
      player.account.getBalance()
    );
  }

  protected String wentBankrupt(Player player, BoardSpace space) {
    try {
      return String.format(
        "The player %s went bankrupt when attempting to pay %d M on %s",
        player.getName(),
        space.getPrice(),
        space.getName()
      );
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
        player.account.getBalance()
      );
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
        player.account.getBalance()
      );
    } catch (Exception e) {
      return e.toString();
    }
  }

  protected String playerRolled(Player player, BoardSpace space) {
    return String.format(
      "The player %s rolled a %d and landed on position %d, %s",
      players[turn].getName(),
      dice.getValue(),
      players[turn].getPosition(),
      space.getName()
    );
  }

  protected String playerPassedStart(Player player) {
    return String.format(
      "The player %s passed the start and recieved %d M and now has %d M",
      players[turn].getName(),
      PASS_START_REWARD,
      players[turn].account.getBalance()
    );
  }

  protected String winnerIs(Player player) {
    return String.format(
      "The winner is %s who had %d M left",
      players[turn].getName(),
      players[turn].account.getBalance()
    );
  }

  protected abstract void displayMessage(String message);

  protected abstract String getUserInput();

  protected abstract void endGame();

  public void play() {
    initPlayers();
    while (isPlaying) {
      System.out.print(
        "Turn: " + players[turn].getName() + ", roll (r), quit (q):"
      );
      var action = getUserInput();
      if (action.equals("r")) {
        playerRollDice();
      } else if (action.equals("q")) {
        break;
      } else {
        System.out.println("Invalid action");
      }
    }
    endGame();
  }

  protected void initPlayers() {
    int playerAmount;
    while (true) {
      System.out.println("How many players are playing (2-4)?: ");
      try {
        var userInput = getUserInput();
        playerAmount = Integer.parseInt(userInput);
        if (playerAmount < 2 || 4 < playerAmount) throw new Exception();
        break;
      } catch (Exception e) {
        System.out.println("Invalid input");
      }
    }
    players = new Player[playerAmount];
    int startBalance;
    if (players.length == 2) {
      startBalance = 20;
    } else if (players.length == 3) {
      startBalance = 18;
    } else {
      startBalance = 16;
    }
    System.out.println(
      String.format(
        "The number of players is %d which means the start balance is %d M",
        playerAmount,
        startBalance
      )
    );
    for (var i = 0; i < players.length; i++) {
      System.out.print("What is the name of player " + (i + 1) + "? ");
      var name = getUserInput();
      int age;
      while (true) {
        System.out.print("What is the age of player " + (i + 1) + "? ");
        try {
          age = Integer.parseInt(getUserInput());
          break;
        } catch (Exception e) {
          System.out.println("Invalid input");
        }
      }

      players[i] = new Player(name, age, 0);
      bank.giveMoney(players[i], startBalance);
    }
    sortPlayersByAge();
  }

  public void stopGame(BoardSpace space) {
    players[turn].isBankrupt = true;
    displayMessage(wentBankrupt(players[turn], space));
    isPlaying = false;
    displayMessage(getWinners());
  }

  private void playerLandedOnSpace(BoardSpace space) {
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
            var paidPlayer =
              players[turn].giveMoney(space.getOwner(), space.getPrice());
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
      var card = chanceCards.pickCard(players[turn], bank, boardSpaces);
      displayMessage(card.getDesctiption());
      switch (card.index) {
        case 0:
          break;
        case 1:
          players[turn].setPosition(0);
          bank.giveMoney(players[turn], 2);
          break;
        case 2:
          while (true) {
            System.out.println("How many spaces do you want to move?");
            try {
              var userInput = getUserInput();
              var userInputInt = Integer.parseInt(userInput);
              if (userInputInt < 1 || 5 < userInputInt) throw new Exception();
              players[turn].setPosition(
                  userInputInt + players[turn].getPosition()
                );
              playerLandedOnSpace(space);
              break;
            } catch (Exception e) {
              System.out.println("Invalid input");
            }
          }
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          bank.takeMoney(players[turn], 2);
          displayMessage(
            "The player" +
            players[turn].getName() +
            " has recieved 2M and now has " +
            players[turn].account.getBalance()
          );
          break;
        case 7:
          break;
        case 8:
          break;
        case 9:
          players[turn].getOutOfJailFree++;
          break;
        case 10:
          players[turn].setPosition(23);
          break;
        case 11:
          break;
        case 12:
          break;
        case 13:
          for (var i = 0; i < players.length; i++) {
            if (i != turn) {
              players[i].giveMoney(players[turn], 1);
            }
          }
          break;
        case 14:
          break;
        case 15:
          bank.giveMoney(players[turn], 2);
          break;
        case 16:
          break;
        case 17:
          players[turn].setPosition(10);
          try {
            if (boardSpaces[10].getOwner() != null) {
              boardSpaces[10].setOwner(players[turn]);
            } else {
              players[turn].giveMoney(
                  boardSpaces[10].getOwner(),
                  boardSpaces[10].getPrice()
                );
            }
          } catch (Exception e) {
            // TODO: handle exception
          }
          break;
        case 18:
          break;
        case 19:
          break;
        default:
          break;
      }
    } else if (space instanceof PassiveSpace) {} else {
      System.out.println("Error: space type not recognized");
    }
  }

  public void playerRollDice() {
    dice.rollDice();
    if (players[turn].getPosition() + dice.getValue() >= boardSpaces.length) {
      bank.giveMoney(players[turn], PASS_START_REWARD);
      displayMessage(playerPassedStart(players[turn]));
    }
    var newPosition =
      (players[turn].getPosition() + dice.getValue()) % boardSpaces.length;
    players[turn].setPosition(newPosition);

    var space = boardSpaces[newPosition];
    displayMessage(playerRolled(players[turn], space));

    playerLandedOnSpace(space);

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
        if (
          players[i].account.getBalance() < players[i + 1].account.getBalance()
        ) {
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
      winners +=
        (i + 1) + ": " + players[i].toString() + System.lineSeparator();
    }
    return winners;
  }
}
