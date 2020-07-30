package domain;

public class Grid {
    private int[][] grid;

    public Grid(int rows, int cols) {
        this.grid = new int[rows][cols];
    }

    public int[][] getGrid() {
        return grid;
    }

    /**
     * Inserts the specified element at the specified position in this
     * grid.
     *
     * @param position coordinates at which the specified element is to be inserted
     * @param rowValue value of element to be inserted
     */
    public void add(Position position, int rowValue) {
        grid[position.getX()][position.getY()] = rowValue;
    }

    /**
     * @return {@code Integer} size of row
     */
    public int getXSize() {
        return grid.length;
    }

    /**
     * @return {@code Integer} size of col
     */
    public int getYSize() {
        return grid[0].length;
    }
}
