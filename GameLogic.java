public abstract class GameLogic {

  BoardSpace[] boardSpaces = {
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
      new ChanceSpace("Biografen", "You've passed the Chance!"),
      new PropertySpace(
          "Vandland",
          "You've passed the Vandland!",
          5,
          Color.DARK_BLUE),
      new PropertySpace(
          "Biografen",
          "You've passed the Strandpromenaden!",
          5,
          Color.DARK_BLUE),
  };
  protected Player[] players;
  protected int turn;
  protected Dice dice;
  protected Bank bank;
  // private ChanceCards chanceCards;

  GameLogic(int playerAmount) {
    players = new Player[playerAmount];
    turn = 0;
    dice = new Dice(6);
    bank = new Bank(90);
    // chanceCards = new ChanceCards();
    initPlayers();
  }

  protected abstract void initPlayers();

  protected abstract void displayMessage(String message);

  public void playerRollDice() {
    dice.rollDice();
    var newPosition = (players[turn].getPosition() + dice.getValue()) % boardSpaces.length;
    players[turn].setPosition(newPosition);

    var space = boardSpaces[newPosition];

    var rolledMessage = String.format("The player %s rolled a %d and landed on position %d, %s",
        players[turn].getName(),
        dice.getValue(),
        players[turn].getPosition(),
        space.getName());
    displayMessage(rolledMessage);

    var message = space.action(players[turn], bank, boardSpaces);
    displayMessage(message);

    switchTurn();
  }

  public void switchTurn() {
    this.turn = (this.turn + 1) % this.players.length;
  }

  public Player getWinner() {
    Player winner;
    var bankruptAmount = 0;
    for (var i = 0; i < players.length; i++) {
      if (players[i].isBankrupt) {
        bankruptAmount++;
      } else {
        winner = players[i];
        if (bankruptAmount == players.length - 1) {
          return winner;
        }
      }
    }
    return null;
  }
}
