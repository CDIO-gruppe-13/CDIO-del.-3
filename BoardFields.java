public class BoardFields {
    private String name;
    private int price;
    private String description;
    private int fieldnumber;

    public BoardFields(String name, int price, String description, int fieldnumber) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.fieldnumber = fieldnumber;
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

    BoardFields Start = new BoardFields("Start,", 0, "You passed the start!", 1);
    BoardFields Burgerbar = new BoardFields("The Burger-bar", 1, "You've passed the Burger-bar!", 2);
    BoardFields ThePizzaria = new BoardFields("The Pizzaria", 1, "You've passed the Pizzaria!", 3);
    BoardFields Chance = new BoardFields("Chance", 0, "You've passed the Chance!", 4);
    BoardFields CandyStore = new BoardFields("The Candy Store", 1, "You've passed the Candy Store!", 5);
    BoardFields Icekiosk = new BoardFields("Ice-kiosk", 1, "You've passed the Ice-kiosk!", 6);
    BoardFields JailVisit = new BoardFields("Jail Visit", 1, "You're on visit to the jail!", 7);
    BoardFields Museum = new BoardFields("The museum", 2, "You've passed the Museum!", 8);
    BoardFields Library = new BoardFields("The Library", 2, "You've passed the Library!", 9);
    BoardFields Chance2 = new BoardFields("Chance", 0, "You've passed the Chance!", 10);
    BoardFields Skatepark = new BoardFields("The Skate park", 2, "You've passed the Skate park!", 11);
    BoardFields Poolen = new BoardFields("The Pool", 2, "You've passed the Pool!", 12);
    BoardFields FreeParking = new BoardFields("Free parking", 0, "You've passed the Free parking!", 13);
    BoardFields Arcade = new BoardFields("Arcade", 3, "You've passed the Arcade!", 14);
    BoardFields Cinema = new BoardFields("Cinema", 3, "You've passed the Cinema!", 15);
    BoardFields Chance3 = new BoardFields("Chance", 0, "You've passed the Chance!", 16);
    BoardFields ToyStore = new BoardFields("The Toystore", 3, "You've passed the Toy store!", 17);
    BoardFields PetShop = new BoardFields("The Pet Shop", 3, "You've passed the Pet Shop!", 18);
    BoardFields Jail = new BoardFields("The Jail", 3, "You've drove to fast go to Jail!", 19);
    BoardFields BowlingHall = new BoardFields("The Bowling Hall", 4, "You've passed the Bowling hall!", 20);
    BoardFields Zoo = new BoardFields("Zoo", 4, "You've passed the Zoo!", 21);
    BoardFields Chance4 = new BoardFields("Chance4", 0, "You've landed on Chance!", 22);
    BoardFields WaterPark = new BoardFields("Water Park", 5, "You've passed the Water Park!", 23);
    BoardFields BeachPromenade = new BoardFields("Beach Promenade", 5, "You've passed the Beach Promenade!", 24);

    /*
     * public static final BoardFields Start = new Fields("Start", 3, "1 M");
     * public static BoardFields[] getAllFields() {
     * return new BoardFields[]{Start};
     * }
     */
}
