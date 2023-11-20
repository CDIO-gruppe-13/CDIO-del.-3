public class PropertySpace extends BoardSpace {

  private int price;
  private Player owner;
  private Color color;

  PropertySpace(String name, String description, int price, Color color) {
    super(name, description);
    this.price = price;
    this.color = color;
  }

  protected String wentBankrupt(Player player) {
    return String.format(
        "The player %s went bankrupt when attempting to pay %d in rent on %s",
        player.getName(),
        price,
        getName());
  }

  protected String boughtProperty(Player player) {
    return String.format(
        "The player %s bought the property %s for %d",
        player.getName(),
        getName(),
        price);
  }

  protected String paidRentToProperty(Player player) {
    return String.format(
        "The player %s paid %d in rent on the space %s",
        player.getName(),
        price,
        getName());
  }

  public String action(Player player, Bank bank, BoardSpace[] boardSpaces) {
    var paidBank = bank.takeMoney(player, price);
    if (!paidBank) {
      player.isBankrupt = true;
      return wentBankrupt(player);
    }
    if (owner == null && paidBank) {
      owner = player;
      return boughtProperty(player);
    } else {
      return paidRentToProperty(player);
    }

  }
}
