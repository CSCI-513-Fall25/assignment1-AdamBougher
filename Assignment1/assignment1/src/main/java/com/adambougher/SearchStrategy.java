package com.adambougher;

import java.util.Vector;

public class SearchStrategy {
    int NumOfCells;
    String Name;
    Vector<Pair> shipCoordinates;

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
        StringBuilder sb = new StringBuilder();
        sb.append("Carrier found: ");
        sb.append(shipCoordinates.get(0).toString());
        sb.append(" to ");
        sb.append(shipCoordinates.get(4).toString());
        System.out.println("Ships found at coordinates: ");
    }

}
