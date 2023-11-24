package com.group13.app;

import java.util.Random;

public class ChanceCards {

  public final ChanceCard[] chanceCards = {
    // new ChanceCard(
    //   "Green Car",
    //   "Give this card to the green car then pull another, Green in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
    //   0,
    //   true,
    //   0
    // ),
    new ChanceCard(
      "Go to Start",
      "You go straight to start and recive 2 M",
      2,
      false,
      1
    ),
    new ChanceCard(
      "Move up to five fields",
      "You may move up to five fields",
      0,
      false,
      2
    ),
    // new ChanceCard(
    //   "Free field: Orange",
    //   "You move forward to an orange field, if its free you get it, if its not free pay rent to the owner",
    //   0,
    //   false,
    //   3
    // ),
    // new ChanceCard(
    //   "Move one field",
    //   "Move one field, or pull another Chance card",
    //   0,
    //   false,
    //   4
    // ),
    // new ChanceCard(
    //   "Ship",
    //   "Give this card to the Ship then pull another, Ship in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
    //   0,
    //   true,
    //   5
    // ),
    new ChanceCard(
      "Pay 2 M",
      "You have eaten too much candy pay 2 M to the bank",
      -2,
      false,
      6
    ),
    // new ChanceCard(
    //   "Free field: Green and Orange",
    //   "You move forward to a Orange or Green field, if its free you get it, if its not free pay rent to the owner",
    //   0,
    //   false,
    //   7
    // ),
    // new ChanceCard(
    //   "Free field: Light Blue",
    //   "You move forward to a Light Blue field, if its free you get it, if its not free pay rent to the owner",
    //   0,
    //   false,
    //   8
    // ),
    new ChanceCard(
      "Get out of jail free",
      "You can get out of jail free, Keep this card until its needed.",
      0,
      true,
      9
    ),
    new ChanceCard("Move to", "Move to the beach promade", 0, false, 10),
    // new ChanceCard(
    //   "Cat",
    //   "Give this card to the Cat then pull another, Cat in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
    //   0,
    //   false,
    //   11
    // ),
    // new ChanceCard(
    //   "Dog",
    //   "Give this card to the Dog then pull another, Dog in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
    //   0,
    //   false,
    //   12
    // ),
    new ChanceCard(
      "Birthday",
      "Its your birthday get 1 M from each Player",
      0/*
       * 1 m from each
       * player
       */,
      false,
      13
    ),
    // new ChanceCard(
    //   "Free field: Pink or Dark blue",
    //   "You move forward to a Pink or Blue field, if its free you get it, if its not free pay rent to the owner",
    //   0,
    //   false,
    //   14
    // ),
    new ChanceCard(
      "Homework",
      "You have finished all your homework recive 2 M from the Bank",
      2,
      false,
      15
    ),
    // new ChanceCard(
    //   "Free field: red",
    //   "You move forward to a Red field, if its free you get it, if its not free pay rent to the owner",
    //   0,
    //   false,
    //   16
    // ),
    new ChanceCard(
      "Skate park",
      "Move to the Skate Park, if its free you get it, else pay rent",
      0,
      false,
      17
    ),
    // new ChanceCard(
    //   "Free field: Light Blue and Red",
    //   "You move forward to a Light Blue or Red field, if its free you get it, if its not free pay rent to the owner",
    //   0,
    //   false,
    //   18
    // ),
    // new ChanceCard(
    //   "Free field: Brown and yellow",
    //   "You move forward to a Brown or yellow field, if its free you get it, if its not free pay rent to the owner",
    //   0,
    //   false,
    //   19
    // ),
  };
  private int index;
  private int[] order;

  public ChanceCards() {
    index = 0;
    order = new int[chanceCards.length];
    for (var i = 0; i < chanceCards.length; i++) {
      order[i] = i;
    }
    shuffleCards();
  }

  private void shuffleCards() {
    Random rand = new Random();
    for (var i = 0; i < chanceCards.length; i++) {
      int randomNumber = rand.nextInt(chanceCards.length);
      var temp = order[i];
      order[i] = order[randomNumber];
      order[randomNumber] = temp;
    }
  }

  public ChanceCard pickCard(
    Player player,
    Bank bank,
    BoardSpace[] boardspaces
  ) {
    index++;
    if (index < chanceCards.length) {
      shuffleCards();
      index = 1;
    }
    return chanceCards[order[index - 1]];
  }
}
