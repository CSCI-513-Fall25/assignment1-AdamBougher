package com.adambougher;

public class GameGrid {
    int[][] grid;

    GameGrid(int rows, int cols){
        grid = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = 0;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    void SetShip(Ship ship) {
        for (int i = 0; i < ship.pos.length; i++) {
            grid[ship.pos[i][0]][ship.pos[i][1]] = 1;
        }
    }

    int get(int row, int col) {
        return grid[row][col];
    }

    boolean CheckPosition(int row, int col) {
        if (grid[row][col] == 1) {
            return true;
        }
        return false;
    }

    int[] getRow(int row) {
        return grid[row];
    }

    void PrintGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    
}
