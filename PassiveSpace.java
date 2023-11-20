public class PassiveSpace extends BoardSpace {

  PassiveSpace(String name, String description) {
    super(name, description);
  }

  public String action(Player player, Bank bank, BoardSpace[] boardSpaces) {
    return "passive";
  }

}
