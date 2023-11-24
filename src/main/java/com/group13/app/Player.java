package com.group13.app;
public class Player {

  private String character;
  private int age;
  private String name;
  private int position;
  public boolean isBankrupt;
  public int getOutOfJailFree;
  public Account account;

  public Player(String name, int age, int startBalance) {
    this.name = name;
    this.age = age;
    this.position = 0;
    getOutOfJailFree = 0;
    isBankrupt = false;
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
    return this.name + ": " + this.account.toString() + " M";
  }

  public boolean giveMoney(Player player, int amount) {
    var balance = account.getBalance();
    if (balance < amount) {
      account.subtractBalance(balance);
      player.account.addBalance(balance);
      return false;
    } else {
      account.subtractBalance(amount);
      player.account.addBalance(amount);
      return true;
    }
  }
}
