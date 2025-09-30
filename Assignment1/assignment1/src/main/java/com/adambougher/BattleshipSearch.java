package com.adambougher;

public class BattleshipSearch {
    GameGrid grid;
    SearchStrategy search;

    BattleshipSearch(SearchStrategy s, Ship carrier, Ship Submarine) {
        grid = new GameGrid(25, 25);
        search = s;
        grid.SetShip(carrier);
        grid.SetShip(Submarine);
    }

    void SetSearchStrategy(SearchStrategy s) {
        search = s;
    }

    void Search(){
        search.FindShip(grid);
    }


}
