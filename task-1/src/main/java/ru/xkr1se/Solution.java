package ru.xkr1se;

import lombok.NonNull;
import lombok.val;

/**
 * @author xkr1se
 */
public class Solution {

    public static String[] towerBuilder(int floors){
        val lengthFloor = 2 * floors - 1;
        val dot = '*';

        val tower = new String[floors];
        val builder = new StringBuilder();

        for (int floor = 1; floor <= floors; floor++) {
            int countDotInFloor = 2 * floor - 1;
            int countSpaces = lengthFloor - countDotInFloor;
            int countSpacesBegin = countSpaces;

            builder.setLength(0);
            for (int position = 0; position < lengthFloor; position++) {
                if(countSpacesBegin / 2 != countSpaces || countDotInFloor == 0) {
                    builder.append(" ");
                    countSpaces--;
                    continue;
                }

                builder.append(dot);
                countDotInFloor--;
            }

            tower[floor - 1] = builder.toString();
        }

        return tower;
    }

}
