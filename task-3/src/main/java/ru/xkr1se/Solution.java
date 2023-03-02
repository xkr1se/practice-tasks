package ru.xkr1se;

/**
 * @author xkr1se
 */
public class Solution {

    public static String makeReadable(int seconds) {
        return String.format("%02d:%02d:%02d", (seconds / 3600), (seconds / 60 % 60), (seconds % 60));
    }

}
