public class ChanceSpace extends BoardSpace {

  ChanceSpace(String name, String description) {
    super(name, description);
  }

  public String action(Player player, Bank bank, BoardSpace[] boardSpaces) {
    return "passive";
  }

}
