public class PropertySpace extends BoardSpace {

  private int price;
  private Player owner;
  private Color color;

  PropertySpace(String name, String description, int price, Color color) {
    super(name, description);
    this.price = price;
    this.color = color;
  }

  public int getRent() {
    return price;
  }

  public Color getColor() {
    return color;
  }

  public Player getOwner() {
    return owner;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  public int getPrice() {
    return price;
  }
}
