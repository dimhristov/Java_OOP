package aquarium;

public class ValidationHelper {

    public static void validateNotNullOrWhiteSpace(Object object, String message) {
        if (object == null || object == "" || object == " ") {
            throw new NullPointerException(message);
        }
    }

    public static void validateIfNegativeOrZero(double number, String message) {
        if (number <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
    public static void validateIfNegativeOrZero(int number, String message) {
        if (number <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
