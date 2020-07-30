package io.impl;

import domain.Grid;
import io.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    private StringBuilder stringBuilder;

    public ConsoleWriter() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void printGrid(Grid grid) {
        stringBuilder = new StringBuilder();
        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid()[row].length; col++) {
                stringBuilder.append(String.format("%s ", grid.getGrid()[row][col]));
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                    .append(System.lineSeparator());
        }

        System.out.println(stringBuilder.toString());
    }
}
