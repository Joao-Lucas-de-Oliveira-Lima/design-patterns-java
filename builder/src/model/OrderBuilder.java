package model;

import enums.Condiment;
import enums.Drink;
import enums.SideDish;
import enums.Snack;

public class OrderBuilder {
    private Order order = new Order();

    private OrderBuilder(){}

    public static OrderBuilder builder(){
        return new OrderBuilder();
    }

    public OrderBuilder snack(Snack snack){
        order.setSnack(snack);
        return this;
    }

    public OrderBuilder drink(Drink drink){
        order.setDrink(drink);
        return this;
    }

    public OrderBuilder condiment(Condiment condiment){
        order.setCondiment(condiment);
        return this;
    }

    public OrderBuilder sideDish(SideDish sideDish){
        order.setSideDish(sideDish);
        return this;
    }

    public Order build(){
        return this.order;
    }
}
