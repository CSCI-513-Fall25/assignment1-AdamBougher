package com.adambougher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String fileName = "Assignment1\\assignment1\\src\\input.txt";
        Vector<Integer> coordinates = new Vector<Integer>();
        Vector<Vector<Ship>> games = new Vector<Vector<Ship>>();
        BattleshipSearch bs;
        

        try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(inputFile);
			StringTokenizer st;
			String line;

			while((line = reader.readLine()) != null) {
				st = new StringTokenizer(line, "(,)");
                games.add(new Vector<Ship>());
                for(int i =0; i < 5; i++){
                    coordinates.add(Integer.parseInt(st.nextToken()));
                    coordinates.add(Integer.parseInt(st.nextToken()));
                }
                games.lastElement().add(new Ship(coordinates,5));
                coordinates.clear();
                for(int i =0; i < 3; i++){
                    coordinates.add(Integer.parseInt(st.nextToken()));
                    coordinates.add(Integer.parseInt(st.nextToken()));
                }
                games.lastElement().add(new Ship(coordinates,3));
                coordinates.clear();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

        for (Vector<Ship> game : games) {
            bs = new BattleshipSearch(new HorizontalSweep(), game.get(0), game.get(1));
            bs.Search();
        }

    }
}