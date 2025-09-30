package com.adambougher;

import java.util.Vector;

public class Ship {
    private ShipType type = ShipType.NONE;
    private Vector<Pair> pos = new Vector<Pair>();

    Ship(Vector<Pair> coordinates, ShipType type) {
        pos = new Vector<>(coordinates);
        this.type = type;
    }

    public Pair getFirstPosition() {
        return pos.get(0);
    }

    public Pair getLastPosition() {
        return pos.get(pos.size() - 1);
    }

    public void PrintShip() {
        System.out.print(type + ": ");
        for (Pair p : pos) {
            System.out.print("(" + p.x + "," + p.y + ") ");
        }
        System.out.println();
    }

    public ShipType getType() {
        return type;
    }

    public Vector<Pair> getPositions() {
        return new Vector<>(pos);
    }

}
