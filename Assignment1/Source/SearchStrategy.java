package com.adambougher;

import java.util.Vector;

public abstract class SearchStrategy {
    int NumOfCells;
    String Name;
    Vector<Pair> shipCoordinates;
    Ship carrier;
    Ship submarine;

    abstract void FindShip(GameGrid grid);

    void PrintName()
    {
        System.out.println("Strategy: " + Name);
    }

    void PrintNumOfCells()
    {
        System.out.println("Number of cells searched: " + NumOfCells);
    }

}
