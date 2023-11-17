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
    BoardFields Burgerbar = new BoardFields("The Burger-bar", 1, "You've passed the Burger-bar!");
    BoardFields ThePizzaria = new BoardFields("The Pizzaria", 1, "You've passed the Pizzaria!");
    BoardFields Chance = new BoardFields("Chance", 0, "You've passed the Chance!");
    BoardFields CandyStore = new BoardFields("The Candy Store", 1, "You've passed the Candy Store!");
    BoardFields Icekiosk = new BoardFields("Ice-kiosk", 1, "You've passed the Ice-kiosk!");
    BoardFields JailVisit = new BoardFields("Jail Visit", 1, "You're on visit to the jail!");
    BoardFields Museum = new BoardFields("The museum", 2, "You've passed the Museum!");
    BoardFields Library = new BoardFields("The Library", 2, "You've passed the Library!");
    BoardFields Chance2 = new BoardFields("Chance", 0, "You've passed the Chance!");
    BoardFields Skatepark = new BoardFields("The Skate park", 2, "You've passed the Skate park!");
    BoardFields Poolen = new BoardFields("The Pool", 2, "You've passed the Pool!");
    BoardFields FreeParking = new BoardFields("Free parking", 0, "You've passed the Free parking!");
    BoardFields Arcade = new BoardFields("Arcade", 3, "You've passed the Arcade!");
    BoardFields Cinema = new BoardFields("Cinema", 3, "You've passed the Cinema!");
    BoardFields Chance3 = new BoardFields("Chance", 0, "You've passed the Chance!");
    BoardFields ToyStore = new BoardFields("The Toystore", 3, "You've passed the Toy store!");
    BoardFields PetShop = new BoardFields("The Pet Shop", 3, "You've passed the Pet Shop!");
    BoardFields Jail = new BoardFields("The Jail", 3, "You've drove to fast go to Jail!");
    BoardFields BowlingHall = new BoardFields("The Bowling Hall", 4, "You've passed the Bowling hall!");
    BoardFields Zoo = new BoardFields("Zoo", 4, "You've passed the Zoo!");
    BoardFields Chance4 = new BoardFields("Chance4", 0, "You've landed on Chance!");
    BoardFields WaterPark = new BoardFields("Water Park", 5, "You've passed the Water Park!");
    BoardFields BeachPromenade = new BoardFields("Beach Promenade", 5, "You've passed the Beach Promenade!");

    /*
     * public static final BoardFields Start = new Fields("Start", 3, "1 M");
     * public static BoardFields[] getAllFields() {
     * return new BoardFields[]{Start};
     * }
     */
}
