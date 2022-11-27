/* ДЗ 15. Автомат с напитками
Используемые инструменты:
1) enum (напитки)
2) константы (цены)
3) static (общая стоимость)
4) switch (выбор напитка)

Задание:
#1 сделайте enum DrinksMachine, который умеет делать КОФЕ, ЧАЙ, ЛИМОНАД, МОХИТО, МИНЕРАЛКУ, КОКА_КОЛУ;
#2 Сделайте класс Drinks, в котором константами задайте цену напитка;
#3 Сделайте подсчет количества сделанных напитков и общей суммы которую должен заплатить клиент;
#4 Сделайте метод для приготовления каждого напитка;
#5 Сделайте switch-case оператор который будет делать напиток(вызывая соответствующий метод) в зависимости от
выбора клиента;
#6 Добавьте возможность выбора напитка для пользователя, и в зависимости от выбора делайте ему напиток;
#7 Пользователь должен иметь возможность заказать несколько напитков
#8 и в конце увидеть сколько денег он должен заплатить;*/

import java.util.Arrays;
import java.util.Scanner;

public class DrinksVendingMachine {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("Автомат с напитками:");
        System.out.println("==================================================================");
        drinksMachine();
        System.out.println("==================================================================");
        System.out.println("Колличество напитков в заказе: " + Drinks.getDrinksCount());
        System.out.println("Стоимость заказа: " + Drinks.getSum());
    }

    private static final String[] drinks = new String[]{
            DrinksMachine.COFFEE.toString(),
            DrinksMachine.TEA.toString(),
            DrinksMachine.LEMONADE.toString(),
            DrinksMachine.MOJITO.toString(),
            DrinksMachine.SODA.toString(),
            DrinksMachine.COCA_COLA.toString(),
    };

    private static void drinksMachine() {
        String drinkChoice = getDrinks();
        switch (drinkChoice) {
            case ("COFFEE") -> {
                Drinks coffee = new Drinks("кофе", "40", DrinksMachine.COFFEE);
                System.out.printf("Ты выбрал %s", coffee.getDrinkName());
            }
            case ("TEA") -> {
                Drinks tea = new Drinks("чай", "30", DrinksMachine.TEA);
                System.out.printf("Ты выбрал %s", tea.getDrinkName());
            }
            case ("LEMONADE") -> {
                Drinks lemonade = new Drinks("лимонад", "25", DrinksMachine.LEMONADE);
                System.out.printf("Ты выбрал %sе", lemonade.getDrinkName());
            }
            case ("MOJITO") -> {
                Drinks mojito = new Drinks("мохито", "35", DrinksMachine.MOJITO);
                System.out.printf("Ты выбрал %s", mojito.getDrinkName());
            }
            case ("SODA") -> {
                Drinks mineralWater = new Drinks("минералку", "15", DrinksMachine.SODA);
                System.out.printf("Ты выбрал %s", mineralWater.getDrinkName());
            }
            case ("COCA_COLA") -> {
                Drinks cocaCola = new Drinks("колу", "20", DrinksMachine.COCA_COLA);
                System.out.printf("Ты выбрал %s", cocaCola.getDrinkName());
            }
            default -> System.out.println("Такого напитка нет в наличии, попробуй еще раз:");
        }
        moreDrinks();
    }

    private static String getDrinks() {
        System.out.println("Сделай выбор:" + Arrays.toString(drinks));
        while (true) {
            Scanner scan = new Scanner(System.in);
            String drinkChoice = scan.nextLine();
            for (String i : drinks) {
                if (i.equals(drinkChoice.toUpperCase())) {
                    return i;
                }
            }
            System.out.println("Такого напитка нет в наличии, попробуй еще раз:");
        }
    }

    private static void moreDrinks() {
        System.out.println("\nЕще напиток? y/n");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.equals("y")) {
                drinksMachine();
                break;
            } else if (!answer.equals("n")) {
                System.out.println("Попробуй еще раз! y/n");
            } else {
                break;
            }
        }
    }
}
