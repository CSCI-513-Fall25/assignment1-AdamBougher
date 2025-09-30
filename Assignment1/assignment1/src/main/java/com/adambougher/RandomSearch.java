package com.adambougher;
import java.util.Random;
import java.util.Vector;

public class RandomSearch extends SearchStrategy {
    @Override
    public void FindShip(GameGrid grid) {
        Name = "Random Search";
        NumOfCells = 0;
        shipCoordinates = new Vector<Pair>();

        boolean[][] visited = new boolean[25][25];
        Random r = new Random();

        while (shipCoordinates.size() < 8) { // We have 2 ships to find
            int x = r.nextInt(25);
            int y = r.nextInt(25);

            if (!visited[x][y]) {
                visited[x][y] = true;
                NumOfCells++;

                if (grid.CheckPosition(x, y)) {
                    shipCoordinates.add(new Pair(x, y));
                }
            }
        }
        PrintName();
        PrintNumOfCells();
        return;
    }

}
