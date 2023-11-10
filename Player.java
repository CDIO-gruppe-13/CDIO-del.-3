public class Player {

  private String character;
  private int age;
  private String name;
  private int position;
  public Account account;

  Player(String name, int age, int startBalance) {
    this.name = name;
    this.age = age;
    this.position = 0;
    this.account = new Account(startBalance);
  }

  public String getName() {
    return this.name;
  }

  public String getCharacter() {
    return character;
  }

  public int getAge() {
    return age;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public String toString() {
    return this.name + ": " + this.account.toString();
  }
}
