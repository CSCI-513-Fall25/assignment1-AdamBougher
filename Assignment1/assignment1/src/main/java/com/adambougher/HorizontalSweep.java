package com.adambougher;
import java.util.Vector;

public class HorizontalSweep extends SearchStrategy {
    @Override
    public void FindShip(GameGrid grid) {
        Name = "Horizontal Sweep";
        NumOfCells = 0;
        shipCoordinates = new Vector<Vector<int[][]>>(25,25);
        PrintName();
        for (int row = 0; row < grid.getGrid().length; row++) {
            if (shipCoordinates.size() >= 8) {
                break;
            }

            for (int col = 0; col < grid.getGrid()[row].length; col++) {
                if (shipCoordinates.size() >= 8) {
                    break;
                }

                NumOfCells++;
                if (grid.CheckPosition(row, col)) {
                    shipCoordinates.add(new Vector<int[][]>(row, col));
                }
            }
        }
        PrintNumOfCells();
        PrintShipsFound();
    }

    
}
