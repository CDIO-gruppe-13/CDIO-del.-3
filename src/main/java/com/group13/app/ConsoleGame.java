package com.group13.app;

import java.util.Scanner;

public class ConsoleGame extends GameLogic {

  Scanner scanner;

  public ConsoleGame() {
    scanner = new Scanner(System.in);
  }

  protected String getUserInput() {
    return scanner.nextLine();
  }

  protected void displayMessage(String message) {
    System.out.println(message);
  }

  protected void endGame() {
      scanner.close();
  }
}
