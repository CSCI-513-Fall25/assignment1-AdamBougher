package com.adambougher;

import java.util.Vector;

public class StrategicSearch extends SearchStrategy {
    boolean[][] visited = new boolean[25][25];

    @Override
    public void FindShip(GameGrid grid) {
        Name = "Strategic Sweep";
        NumOfCells = 0;
        shipCoordinates = new Vector<Pair>();
        

        /// Check every 3rd cell in a row, then move to the next row. becuase the smallest ship is 3 cells long this will ensure
        /// that we will always hit at least one cell of every ship.
        /// If we hit a ship, we then use a recursive function to check all adjacent cells to find the rest of the ship.
        /// We also keep track of visited cells to avoid checking the same cell multiple times.

        for (int row = 0; row < grid.getGrid().length; row++) {

            for (int col = 0; col < grid.getGrid()[row].length; col+=3) {
                NumOfCells++;
                visited[row][col] = true;

                if (grid.CheckPosition(row, col)) {

                    shipCoordinates.addAll(getShipCoordinates(row, col, grid, new Vector<Pair>()));

                }

                if (shipCoordinates.size() >= 8) {
                    PrintName();
                    PrintNumOfCells();
                    return;
                }
            }
        }
    }

    Vector<Pair> getShipCoordinates(int row, int col, GameGrid grid, Vector<Pair> shipCoords) {
        shipCoords.add(new Pair(row, col));
        NumOfCells++;
        visited[row][col] = true;
        
        if (grid.CheckPosition(row+1, col) && !visited[row+1][col]) {
            getShipCoordinates(row+1, col, grid, shipCoords);
        }
        if (grid.CheckPosition(row-1, col) && !visited[row-1][col]) {
            getShipCoordinates(row-1, col, grid, shipCoords);
        }
        if (grid.CheckPosition(row, col+1) && !visited[row][col+1]) {
            getShipCoordinates(row, col+1, grid, shipCoords);
        }
        if (grid.CheckPosition(row, col-1) && !visited[row][col-1]) {
            getShipCoordinates(row, col-1, grid, shipCoords);
        }
        return shipCoords;
    }

}
