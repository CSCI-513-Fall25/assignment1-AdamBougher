package com.adambougher;

import java.util.Vector;

public class Ship {
    int[][] pos;

    Ship(Vector<Integer> coordinates, int size) {
        pos = new int[size][2];
        for (int i = 0; i < coordinates.size() / 2; i++) {
            pos[i][0] = coordinates.get(i * 2);
            pos[i][1] = coordinates.get(i * 2 + 1);
        }
    }

}
