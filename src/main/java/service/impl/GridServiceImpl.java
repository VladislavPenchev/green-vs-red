package service.impl;

import domain.Grid;
import domain.Position;
import io.InputReader;
import service.GridService;
import util.SplitterUtil;

import java.io.IOException;
import java.util.List;

public class GridServiceImpl implements GridService {

    private final InputReader consoleReader;

    public GridServiceImpl(InputReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public void generateGrid(Grid grid) throws IOException {
        for(int row = 0; row < grid.getXSize(); row++){
            List<Integer> rowArgs = SplitterUtil.splitRowArgs(consoleReader.readLine());
            for(int col = 0; col < grid.getYSize(); col++) {
                Position position = new Position();
                position.setX(row);
                position.setY(col);
                grid.add(position, rowArgs.get(col));
            }
        }
    }

    public Grid nextGeneration(Grid grid, Position position) {
        int neighbours;
        Grid newGrid = copyGrid(grid);

        for (int row = 0; row < grid.getGrid().length; row++) {
            for (int col = 0; col < grid.getGrid()[row].length; col++) {
                neighbours = calculateGreenNeighbours(grid, row, col);
                if (grid.getGrid()[row][col] == 0) {
                    if (neighbours == 3 || neighbours == 6) {
                        position = new Position();
                        position.setX(row);
                        position.setY(col);
                        newGrid.add(position, 1);
                    }
                } else {
                    if (neighbours != 3 && neighbours != 6 && neighbours != 2) {
                        position = new Position();
                        position.setX(row);
                        position.setY(col);
                        newGrid.add(position, 0);
                    }
                }
            }
        }
        return newGrid;
    }

    /**
     * @param grid non empty grid
     * @return {@code Grid} copy of grid
     */
    private Grid copyGrid(Grid grid) {
        Grid newGrid = new Grid(grid.getXSize(), grid.getYSize());

        for(int row = 0; row < grid.getXSize(); row++ ) {
            for(int col = 0; col < grid.getYSize(); col++) {
                Position position = new Position(row, col);
                newGrid.add(position, grid.getGrid()[row][col]);
            }
        }
        return newGrid;
    }

    /**
     * Foreach all neighbour cells and calculate sum of green cells. Ignore all
     * coordinates that are invalid.
     *
     * @param grid non empty grid
     * @param rowArg current coordinate of row
     * @param colArg current coordinate of col
     * @return {@code Integer} sum of green neighbours.
     */
    private int calculateGreenNeighbours(Grid grid, int rowArg, int colArg) {
        int sumOfGreen = 0;
        int initRow = rowArg - 1;
        int initCol = colArg - 1;

        sumOfGreen -= grid.getGrid()[rowArg][colArg];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if(initRow + row < 0 || initCol + col < 0 || initRow + row > grid.getXSize() - 1 || initCol + col > grid.getYSize() - 1) {
                    continue;
                }
                sumOfGreen += grid.getGrid()[initRow + row][initCol + col];
            }
        }
        return sumOfGreen;
    }
}
