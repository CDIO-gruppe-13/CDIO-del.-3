package com.group13.app;

import java.util.Scanner;

public class ConsoleGame extends GameLogic {

  Scanner scanner;

  public ConsoleGame(int playerAmount) {
    super(playerAmount);
  }

  public void play() {
    while (getWinner() == null) {
      System.out.print("Turn: " + players[turn].getName() + ", roll (r), quit (q):");
      var action = scanner.nextLine();
      if (action.equals("r")) {
        playerRollDice();
      } else if (action.equals("q")) {
        break;
      } else {
        System.out.println("Invalid action");
      }
    }
    scanner.close();
  }

  protected void initPlayers() {
    scanner = new Scanner(System.in);
    int startBalance;
    if (players.length == 2) {
      startBalance = 20;
    } else if (players.length == 3) {
      startBalance = 18;
    } else {
      startBalance = 16;
    }
    for (var i = 0; i < players.length; i++) {
      System.out.print("What is the name of player " + (i + 1) + "? ");
      var name = scanner.nextLine();
      System.out.print("What is the age of player " + (i + 1) + "? ");
      var age = Integer.parseInt(scanner.nextLine());
      players[i] = new Player(name, age, 0);
      bank.giveMoney(players[i], startBalance);
    }
  }

  protected void displayMessage(String message) {
    System.out.println(message);
  };
}
