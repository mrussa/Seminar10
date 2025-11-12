package backend.academy.seminar9.exceptions;

import java.util.StringJoiner;

public class NotEnoughSuppliesException extends RuntimeException {

    public NotEnoughSuppliesException(int coffee, int water, int milk) {
        super("Not enough supplies: " + buildMissingSuppliesMessage(coffee, water, milk));
    }

    private static String buildMissingSuppliesMessage(int coffee, int water, int milk) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        if (coffee > 0) {
            stringJoiner.add("Coffee: " + coffee);
        }
        if (water > 0) {
            stringJoiner.add("Water: " + water);
        }
        if (milk > 0) {
            stringJoiner.add("Milk: " + milk);
        }

        return stringJoiner.toString();
    }
}
