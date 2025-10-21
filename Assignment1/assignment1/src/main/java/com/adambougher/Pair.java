package com.adambougher;

public class Pair {
    public int x;
    public int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean compare(int first, int second) {
        return this.x == first && this.y == second;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
