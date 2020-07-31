package service;

import domain.Grid;
import domain.Position;

import java.io.IOException;
import java.util.List;

public interface GridService {

    Grid nextGeneration(Grid grid, Position position);

    void generateGrid(Grid grid, List<String> rowsArgs) throws IOException;
}
