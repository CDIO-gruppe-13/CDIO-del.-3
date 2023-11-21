package com.group13.app;
public abstract class BoardSpace {

  private String name;
  private String description;

  public BoardSpace(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isOwnable() {
    return false;
  }

  public int getPrice() throws Exception {
    throw new Exception();
  }

  public Color getColor() throws Exception {
    throw new Exception();
  }

  public Player getOwner() throws Exception {
    throw new Exception();
  }

  public void setOwner(Player newOwner) throws Exception {
    throw new Exception();
  }

}
