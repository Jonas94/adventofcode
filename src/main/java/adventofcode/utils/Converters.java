package adventofcode.utils;

import java.util.Set;
import java.util.stream.Collectors;

public class Converters {

    public static Set<Character> stringToCharSet(String string) {
        return string.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

    }
}
