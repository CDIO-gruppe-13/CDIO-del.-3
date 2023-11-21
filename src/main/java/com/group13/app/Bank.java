package com.group13.app;
public class Bank {

  private int balance;

  public Bank(int startBalance) {
    balance = startBalance;
  }

  public boolean giveMoney(Player player, int balance) {
    if (this.balance - balance < 0) {
      this.balance = 0;
      player.account.addBalance(this.balance - balance);
      return false;
    }
    this.balance -= balance;
    player.account.addBalance(balance);
    return true;
  }

  public boolean takeMoney(Player player, int balance) {
    var balanceDiff = player.account.getBalance() - balance;
    if (balanceDiff < 0) {
      player.account.subtractBalance(balanceDiff);
      this.balance += balanceDiff;
      return false;
    }

    player.account.subtractBalance(balance);
    this.balance += balance;
    return true;
  }
}
