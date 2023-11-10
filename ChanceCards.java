public class ChanceCards {
    private String name;
    private String desctiption;

    public ChanceCards(String name, String description) {
        this.name = name;
        this.desctiption = description;
    }

    public ChanceCards[] CardDeck;

    public ChanceCards() {
        CardDeck = new ChanceCards[20];

        CardDeck[1] = new ChanceCards();
        CardDeck[2] = new ChanceCards();
        CardDeck[3] = new ChanceCards();
        CardDeck[4] = new ChanceCards();
        CardDeck[5] = new ChanceCards();
        CardDeck[6] = new ChanceCards();
        CardDeck[7] = new ChanceCards();
        CardDeck[8] = new ChanceCards();
        CardDeck[9] = new ChanceCards();
        CardDeck[10] = new ChanceCards();
        CardDeck[11] = new ChanceCards();
        CardDeck[12] = new ChanceCards();
        CardDeck[13] = new ChanceCards();
        CardDeck[14] = new ChanceCards();
        CardDeck[15] = new ChanceCards();
        CardDeck[16] = new ChanceCards();
        CardDeck[17] = new ChanceCards();
        CardDeck[18] = new ChanceCards();
        CardDeck[19] = new ChanceCards();
        CardDeck[20] = new ChanceCards();
    }

}
