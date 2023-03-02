package ru.xkr1se;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xkr1se
 */
public class Solution {
    public static String order(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b)
                .get();
    }
}
