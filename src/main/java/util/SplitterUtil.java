package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitterUtil {

    /**
     * Split argument by regex ", "
     *
     * @param rowsAndColsArgs contains counts of rows and cols
     * @return {@code List<Integer>} first position - row, second position - col
     */
    public static List<Integer> rowsAndCols(String rowsAndColsArgs) {
        return Arrays.stream(rowsAndColsArgs.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Split argument by regex ""
     *
     * @param rowArgs collection contains all rows as string
     * @return {@code List<Integer[]>} collection with all rows elements as Array of integers
     */
    public static List<Integer[]> splitRowArgs(List<String> rowArgs) {
        return rowArgs.stream()
                .map(row -> Arrays.stream(row.split(""))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new))
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Split argument by regex ", "
     *
     * @param positionAndTurnArgs contains coordinates of cell that we want to explore and turns.
     * @return {@code List<Integer>} collection with only coordinates of cell
     */
    public static List<Integer> splitPositionArgs(String positionAndTurnArgs) {
        return Arrays.stream(positionAndTurnArgs.split(", "))
                .map(Integer::parseInt)
                .limit(2)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Split argument by regex ", "
     *
     * @param positionAndTurnArgs contains coordinates of cell that we want to explore and turns.
     * @return {@code Integer} number of turns
     */
    public static int splitTurnsArgs(String positionAndTurnArgs) {
        String[] turnsArgs = positionAndTurnArgs.split(", ");
        return Integer.parseInt(turnsArgs[turnsArgs.length - 1]);
    }
}
