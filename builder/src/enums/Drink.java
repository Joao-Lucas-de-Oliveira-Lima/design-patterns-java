package enums;

public enum Drink {
    SODA("Soda"), 
    TEA("Tea"),
    COFFEE("Coffee"),
    WATER("Water");

    private String name;

    Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
