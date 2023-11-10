public class Account {

  private int balance;

  Account(int startBalance) {
    this.balance = startBalance;
  }

  public int getBalance() {
    return balance;
  }

  public void subtractBalance(int balance) {
    this.balance -= balance;
  }

    public void addBalance(int balance) {
    this.balance += balance;
  }

  public String toString() {
    return "The account has the balance: " + this.balance;
  }
}
