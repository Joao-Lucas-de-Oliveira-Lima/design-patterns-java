package enums;

public enum SideDish {
    FRIES("Fries"), 
    ONION_RINGS("Onion Rings"),
    SALAD("Salad"),
    COLESLAW("Coleslaw");

    private String name;

    SideDish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
