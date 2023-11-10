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

    BoardFields Start = new BoardFields("Start,", 3, "Test");
    /*
     * public static final BoardFields Start = new Fields("Start", 3, "1 M");
     * public static BoardFields[] getAllFields() {
     * return new BoardFields[]{Start};
     * }
     */
}
