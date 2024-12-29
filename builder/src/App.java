import enums.Condiment;
import enums.Drink;
import enums.SideDish;
import enums.Snack;
import model.Order;
import model.OrderBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        Order order01 = OrderBuilder.builder()
                .snack(Snack.POPCORN)
                .drink(Drink.SODA)
                .condiment(Condiment.KETCHUP)
                .sideDish(SideDish.FRIES)
                .build();

        Order order02 = OrderBuilder.builder()
                .snack(Snack.CHIPS)
                .drink(Drink.SODA)
                .build();

        Order order03 = OrderBuilder.builder()
                .drink(Drink.SODA)
                .build();

        System.out.println(order01);
        System.out.println(order02);
        System.out.println(order03);
    }
}
