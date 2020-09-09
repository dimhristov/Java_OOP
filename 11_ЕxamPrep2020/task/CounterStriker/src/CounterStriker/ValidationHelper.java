package CounterStriker;

public class ValidationHelper {

    public static void validateNotNull(Object object,String exception) {
        if (object == null || object.equals("")) {
            throw new NullPointerException(exception);
        }
    }

    public static void validateInRange(int quantity, String exception) {
        if (quantity < 0) {
            throw new IllegalArgumentException(exception);
        }
    }
}
