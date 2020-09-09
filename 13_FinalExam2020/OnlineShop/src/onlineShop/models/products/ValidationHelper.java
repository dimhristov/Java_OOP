package onlineShop.models.products;

import onlineShop.common.constants.ExceptionMessages;

public class ValidationHelper {

    public static void validateNotLessOrNotZero(int number, String message) {
        if (number <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotNull(String string, String message) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotLessOrNotZero(double number, String message) {
        if (number <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
