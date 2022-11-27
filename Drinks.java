import java.math.BigDecimal;

public class Drinks {
    public Drinks(String drinkName, String price, DrinksMachine drink) {
        this.drinkName = drinkName;
        this.price = new BigDecimal(price);
        this.drink = drink;
        drinksCount++;
        BigDecimal sum = new BigDecimal(price);
        commonPrice = commonPrice.add(sum);
    }

    private static int drinksCount;
    private final BigDecimal price;
    private final String drinkName;
    private final DrinksMachine drink;
    private static BigDecimal commonPrice = new BigDecimal("0");

    public BigDecimal getPrice() {
        return price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public DrinksMachine getDrink() {
        return drink;
    }

    public static int getDrinksCount() {
        return drinksCount;
    }

    public static BigDecimal getSum() {
        return commonPrice;
    }
}

