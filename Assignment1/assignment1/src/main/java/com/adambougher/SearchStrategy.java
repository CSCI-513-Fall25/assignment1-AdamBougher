package com.adambougher;

import java.util.Vector;

public class SearchStrategy {
    int NumOfCells;
    String Name;
    Vector<Vector<int[][]>> shipCoordinates;

    void FindShip(GameGrid grid){

    }
    void PrintName()
    {
        System.out.println("Strategy: " + Name);
    }

    void PrintNumOfCells()
    {
        System.out.println("Number of cells searched: " + NumOfCells);
    }

    void PrintShipsFound(){
        System.out.println("Ships found at:");
        for (Vector<int[][]> coord : shipCoordinates) {
            for (int[][] pos : coord) {
                System.out.println("Ship found at (" + pos[0] + "," + pos[1] + ")");
            }
        } 
    }

}
