public class JailSpace extends BoardSpace {

  JailSpace(String name, String description) {
    super(name, description);
  }

  public String action(Player player, Bank bank, BoardSpace[] boardSpaces) {
    return "jail";
  }
}
