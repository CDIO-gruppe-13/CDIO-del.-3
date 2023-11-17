public class BoardFields {
    private String name;
    private int price;
    private String description;

    public BoardFields(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    BoardFields Start = new BoardFields("Start,", 0, "You passed the start!");
    BoardFields Burgerbar = new BoardFields("Burgerbar", 1, "You've passed the Burgerbar!");
    BoardFields Pizzariaet = new BoardFields("Pizzariaet", 1, "You've passed the Pizzaria!");
    BoardFields Chance = new BoardFields("Chance", 0, "You've passed the Chance!");
    BoardFields Slikbutikken = new BoardFields("Slikbutikken", 1, "You've passed the Slikbutik!");
    BoardFields Iskiosken = new BoardFields("Iskiosken", 1, "You've passed the Iskiosk!");
    BoardFields Fængselbesøg = new BoardFields("Fængselsbesøg", 1, "You've passed the På besøg i fængsel!");
    BoardFields Museet = new BoardFields("Museet", 2, "You've passed the Museum!");
    BoardFields Biblioteket = new BoardFields("Biblioteket", 2, "You've passed the Bibliotek!");
    BoardFields Chance2 = new BoardFields("Chance", 0, "You've passed the Chance!");
    BoardFields Skaterparken = new BoardFields("Skaterparken", 2, "You've passed the Skaterpark!");
    BoardFields Poolen = new BoardFields("Poolen", 2, "You've passed the Pool!");
    BoardFields Gratisparkering = new BoardFields("Gratis parkering", 0, "You've passed the Gratis parkering!");
    BoardFields Spillehallen = new BoardFields("Spillehallen", 3, "You've passed the Spillehal!");
    BoardFields Biografen = new BoardFields("Biografen", 3, "You've passed the Biograf!");
    BoardFields Chance3 = new BoardFields("Chance", 0, "You've passed the Chance!");
    BoardFields Legetøjsbutikken = new BoardFields("Legetøjsbutikken", 3, "You've passed the Legetøjsbutik!");
    BoardFields Dyrehandler = new BoardFields("Dyrehandler", 3, "You've passed the Dyrehandler!");
    BoardFields Fængsel = new BoardFields("Fængsel", 3, "You've passed the Fængsel!");
    BoardFields Bowlinghal = new BoardFields("Bowlinghallen", 4, "You've passed the Bowlinghal!");
    BoardFields Zoo = new BoardFields("Zoo", 4, "You've passed the Zoo!");
    BoardFields Chance4 = new BoardFields("Biografen", 0, "You've passed the Chance!");
    BoardFields Vandland = new BoardFields("Vandland", 5, "You've passed the Vandland!");
    BoardFields Strandpromenaden = new BoardFields("Strandpromenaden", 5, "You've passed the Strandpromenaden!");

    
    /*
     * public static final BoardFields Start = new Fields("Start", 3, "1 M");
     * public static BoardFields[] getAllFields() {
     * return new BoardFields[]{Start};
     * }
     */
}
