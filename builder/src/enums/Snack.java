package enums;

public enum Snack {
    SANDWICH("Sandwich"), 
    CHIPS("Chips"),
    COOKIES("Cookies"),
    POPCORN("Popcorn");

    private String name;

    Snack(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
