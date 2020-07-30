package core.impl;

import core.Engine;
import domain.Position;
import domain.Grid;
import io.InputReader;
import io.OutputWriter;
import service.GridService;
import service.impl.GridServiceImpl;
import util.SplitterUtil;

import java.io.IOException;
import java.util.List;

public class GameEngine implements Engine {

    private final InputReader consoleReader;
    private final OutputWriter consoleWriter;
    private final GridService gridService;
    private boolean isStarted;

    public GameEngine(InputReader consoleReader, OutputWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
        this.gridService = new GridServiceImpl(consoleReader);
        this.isStarted = true;
    }

    @Override
    public void start() {
        while(isStarted) {
            try {
                String rowsAndColsArgs = consoleReader.readLine();
                List<Integer> rowsAndCols = SplitterUtil.rowsAndCols(rowsAndColsArgs);
                if(rowsAndCols.get(0) < 0 || rowsAndCols.get(1) < 0){
                    consoleWriter.writeLine("Row or col can not be less than zero!");
                    isStarted = false;
                    return;
                }

                Grid grid = new Grid(rowsAndCols.get(0), rowsAndCols.get(1));
                gridService.generateGrid(grid);

                String positionAndTurnArgs = consoleReader.readLine();
                List<Integer> positions = SplitterUtil.splitPositionArgs(positionAndTurnArgs);
                Position position = new Position(positions.get(0), positions.get(1));

                int turns = SplitterUtil.splitTurnsArgs(positionAndTurnArgs);

                consoleReader.getReader().close();

                consoleWriter.writeLine(String.format("Grid - %d", 0));
                consoleWriter.printGrid(grid);

                int sumOfGreenGenerations = 0;
                for(int turn = 1; turn <= turns; turn++) {
                    grid = gridService.generateGridX(grid, position);
                    sumOfGreenGenerations += grid.getGrid()[position.getX()][position.getY()];

                    consoleWriter.writeLine(String.format("Grid - %d", turn));
                    consoleWriter.printGrid(grid);
                }

                consoleWriter.writeLine(String.format("The cell with position [%d, %d] became green in %d turns - %d times",
                        position.getX(), position.getY(), turns, sumOfGreenGenerations));

                isStarted = false;

            } catch (IOException e) {
                consoleWriter.writeLine(String.format("An error has occurred while reading input - %s", e.getMessage()));
            }
        }
    }
}
