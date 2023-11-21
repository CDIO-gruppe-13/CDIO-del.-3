package com.group13.app;
public class PropertySpace extends BoardSpace {

  private int price;
  private Player owner;
  private Color color;

  public PropertySpace(String name, String description, int price, Color color) {
    super(name, description);
    this.price = price;
    this.color = color;
  }

  @Override
  public boolean isOwnable() {
    return true;
  }

  @Override
  public int getPrice() throws Exception {
    return price;
  }

  @Override
  public Color getColor() throws Exception {
    return color;
  }

  @Override
  public Player getOwner() throws Exception {
    return owner;
  }

  @Override
  public void setOwner(Player newOwner) throws Exception {
    owner = newOwner;
  }
}
