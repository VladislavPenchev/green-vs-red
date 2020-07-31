package service;

import domain.Grid;
import domain.Position;

import java.io.IOException;

public interface GridService {

    Grid nextGeneration(Grid grid, Position position);

    void generateGrid(Grid grid) throws IOException;
}
