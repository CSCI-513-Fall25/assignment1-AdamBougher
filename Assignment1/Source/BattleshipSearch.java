package com.adambougher;

public class BattleshipSearch {
    GameGrid grid;
    SearchStrategy search;
    Ship carrier;
    Ship submarine;

    BattleshipSearch(SearchStrategy s, Ship carrier, Ship submarine) {
        grid = new GameGrid(25, 25);
        search = s;
        grid.SetShip(carrier);
        grid.SetShip(submarine);
        this.carrier = carrier;
        this.submarine = submarine;
    }

    public void SetStrategy(SearchStrategy s) {
        search = s;
    }

    void Search(){
        search.FindShip(grid);
        PrintShipsFound();
    }


    void PrintShipsFound(){
        StringBuilder sb = new StringBuilder();
        sb.append("Carrier found: ");
        sb.append(carrier.getFirstPosition().toString());
        sb.append(" to ");
        sb.append(carrier.getLastPosition().toString());

        sb.append(" Submarine found: ");
        sb.append(submarine.getFirstPosition().toString());
        sb.append(" to ");
        sb.append(submarine.getLastPosition().toString());
        System.out.println(sb);
    }


}
