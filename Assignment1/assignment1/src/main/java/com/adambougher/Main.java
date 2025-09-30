package com.adambougher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        String fileName = "Assignment1\\assignment1\\src\\input.txt";
        Vector<Pair> coordinates = new Vector<Pair>();
        Vector<Ship> ships;
        Vector<Vector<Ship>> games = new Vector<Vector<Ship>>();
        BattleshipSearch bs;
        

        try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(inputFile);
			StringTokenizer st;
			String line;

			

			while((line = reader.readLine()) != null) {
				st = new StringTokenizer(line, "(,)");
                ships = new Vector<Ship>();

                for(int i =0; i < 5; i++){
                    Pair p = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    coordinates.add(p);
                }

                ships.add(new Ship(coordinates, ShipType.CARRIER));
                coordinates.clear();

                for(int i =0; i < 3; i++){
                    coordinates.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                }

                ships.add(new Ship(coordinates, ShipType.SUBMARINE));
                coordinates.clear();

                games.add(ships);
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