package model;

import enums.Condiment;
import enums.Drink;
import enums.SideDish;
import enums.Snack;

public class Order {
    private Snack snack;
    private Drink drink;
    private Condiment condiment;
    private SideDish sideDish;

    protected Order(){}

    public Snack getSnack() {
        return snack;
    }

    public void setSnack(Snack snack) {
        this.snack = snack;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Condiment getCondiment() {
        return condiment;
    }

    public void setCondiment(Condiment condiment) {
        this.condiment = condiment;
    }

    public SideDish getSideDish() {
        return sideDish;
    }

    public void setSideDish(SideDish sideDish) {
        this.sideDish = sideDish;
    }

    @Override
    public String toString(){
        String response = "Order: ";
        response += this.condiment == null ? "" : this.condiment.getName()+", ";
        response += this.snack == null ? "" : this.snack.getName()+", ";
        response += this.drink == null ? "" : this.drink.getName()+", ";
        response += this.sideDish == null ? "" : this.sideDish.getName();
        if(response.endsWith(", ")){
            response = response.substring(0, response.length()-3);
        }
        return response;
    }

}
