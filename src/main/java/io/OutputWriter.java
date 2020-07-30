package io;

import domain.Grid;

public interface OutputWriter {
    void writeLine(String line);

    /**
     * Foreach the grid and print all elements.
     *
     * @param grid contains non empty grid.
     */
    void printGrid(Grid grid);
}
