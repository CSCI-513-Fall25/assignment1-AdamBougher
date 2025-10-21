package com.adambougher;

import java.util.Vector;

public class StrategicSearch extends SearchStrategy {
    boolean[][] visited = new boolean[25][25];

    @Override
    public void FindShip(GameGrid grid) {
        Name = "Strategic Sweep";
        NumOfCells = 0;
        shipCoordinates = new Vector<Pair>();
        

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
