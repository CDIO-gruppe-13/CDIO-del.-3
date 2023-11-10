public class BoardFields {
    private String name;
    private int price;
    private String description;

    public void Fields(String name, int price, String description) {
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
}
