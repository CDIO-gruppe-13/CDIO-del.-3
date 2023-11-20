public abstract class BoardSpace {

  private String name;
  private String description;

  BoardSpace(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public abstract String action(Player player, Bank bank, BoardSpace[] boardSpaces);
}
