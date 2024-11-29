package adventofcode.utils;

public class ParseHelper {
    public static Integer parseIntOrZero(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Something went wrong parsing number");
            return 0;
        }
    }
}
