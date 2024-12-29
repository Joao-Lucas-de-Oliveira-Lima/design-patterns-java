package enums;

public enum Condiment {
    KETCHUP("Ketchup"), 
    MUSTARD("Mustard"),
    MAYO("Mayo"),
    RELISH("Relish");

    private String name;

    Condiment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
