package com.group13.app;
public class ChanceCards {
    private String name;
    private String desctiption;
    private int value;
    private boolean stash;

    public ChanceCards(String name, String description, int value, boolean stash) {
        this.name = name;
        this.desctiption = description;
        this.value = value;
        this.stash = stash;
    }

    public ChanceCards[] CardDeck;

    public ChanceCards() {
        CardDeck = new ChanceCards[20];

        CardDeck[1] = new ChanceCards("Green Car",
                "Give this card to the green car then pull another, Green in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
                0, true);
        CardDeck[2] = new ChanceCards("Go to Start", "You go straight to start and recive 2 M", 2, false);
        CardDeck[3] = new ChanceCards("Move up to five fields", "You may move up to five fields", 0, false);
        CardDeck[4] = new ChanceCards("Free field: Organge",
                "You move forward to a oragne field, if its free you get it, if its not free pay rent to the owner", 0,
                false);
        CardDeck[5] = new ChanceCards("Move one field", "Move one field, or pull another Chance card", 0, false);
        CardDeck[6] = new ChanceCards("Ship",
                "Give this card to the Ship then pull another, Ship in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
                0, true);
        CardDeck[7] = new ChanceCards("Pay 2 M", "You have eaten too much candy pay 2 M to the bank", -2, false);
        CardDeck[8] = new ChanceCards("Free field: Green and Orange",
                "You move forward to a Orange or Green field, if its free you get it, if its not free pay rent to the owner",
                0, false);
        CardDeck[9] = new ChanceCards("Free field: Light Blue",
                "You move forward to a Light Blue field, if its free you get it, if its not free pay rent to the owner",
                0, false);
        CardDeck[10] = new ChanceCards("Get out of jail free",
                "You can get out of jail free, Keep this card until its needed.", 0, true);
        CardDeck[11] = new ChanceCards("Move to", "Move to the beach promade", 0, false);
        CardDeck[12] = new ChanceCards("Cat",
                "Give this card to the Cat then pull another, Cat in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
                0, false);
        CardDeck[13] = new ChanceCards("Dog",
                "Give this card to the Dog then pull another, Dog in your turn move to any free field and buy it, if theres no free fields buy one from any player.",
                0, false);
        CardDeck[14] = new ChanceCards("Birthday", "Its your birthday get 1 M from each Player", 0 /*
                                                                                                    * 1 m from each
                                                                                                    * player
                                                                                                    */, false);
        CardDeck[15] = new ChanceCards("Free field: Pink or Dark blue",
                "You move forward to a Pink or Blue field, if its free you get it, if its not free pay rent to the owner",
                0, false);
        CardDeck[16] = new ChanceCards("Homework", "You have finished all your homework recive 2 M from the Bank", 2,
                false);
        CardDeck[17] = new ChanceCards("Free field: red",
                "You move forward to a Red field, if its free you get it, if its not free pay rent to the owner", 0,
                false);
        CardDeck[18] = new ChanceCards("Skate park", "Move to the Skate Park, if its free you get it, else pay rent", 0,
                false);
        CardDeck[19] = new ChanceCards("Free field: Light Blue and Red",
                "You move forward to a Light Blue or Red field, if its free you get it, if its not free pay rent to the owner",
                0, false);
        CardDeck[20] = new ChanceCards("Free field: Brown and yellow",
                "You move forward to a Brown or yellow field, if its free you get it, if its not free pay rent to the owner",
                0, false);
    }

}
