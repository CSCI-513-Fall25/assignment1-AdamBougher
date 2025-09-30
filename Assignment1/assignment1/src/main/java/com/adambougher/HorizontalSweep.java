package com.adambougher;
import java.util.Vector;


public class HorizontalSweep extends SearchStrategy {
    @Override
    public void FindShip(GameGrid grid) {
        Name = "Horizontal Sweep";
        NumOfCells = 0;
        shipCoordinates = new Vector<Pair>();
        PrintName();

        for (int row = 0; row < grid.getGrid().length; row++) {

            for (int col = 0; col < grid.getGrid()[row].length; col++) {
                NumOfCells++;
                if (grid.CheckPosition(row, col)) {
                    shipCoordinates.add(new Pair(row, col));
                }

                    if (shipCoordinates.size() >= 8) {
                        PrintNumOfCells();
                        PrintShipsFound();
                        return;
                    }
            }
        }
    }

    
}
