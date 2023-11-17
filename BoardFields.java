public class BoardFields {

  BoardSpace boardField[] = {
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
    new JailSpace("Fængselsbesøg", "You've passed the På besøg i fængsel!"),
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
    new ChanceSpace("Biografen", "You've passed the Chance!"),
    new PropertySpace(
      "Vandland",
      "You've passed the Vandland!",
      5,
      Color.DARK_BLUE
    ),
    new PropertySpace(
      "Biografen",
      "You've passed the Strandpromenaden!",
      5,
      Color.DARK_BLUE
    ),
  };
}
