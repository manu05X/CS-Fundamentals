package com.manish.LLD.TicTacToe2.strategies.winningstrategies;


import com.manish.LLD.TicTacToe2.models.Board;
import com.manish.LLD.TicTacToe2.models.Moves;
import com.manish.LLD.TicTacToe2.models.Player;
import com.manish.LLD.TicTacToe2.models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneRowWinningStrategy implements WinningStrategy {
    //using Map logic for cheking winner
    private List<Map<Symbol, Integer>> rowMaps;

    //constructor for map initialization using (size of board and players)
    public OrderOneRowWinningStrategy(int size, List<Player> players) {
        rowMaps = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            rowMaps.add(new HashMap<>());
            for (Player player: players) {
                rowMaps.get(i).put(player.getSymbol(), 0);
            }
        }
    }

    @Override
    public boolean checkWinning(Board board, Moves move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();

        rowMaps.get(row).put(symbol, 1+rowMaps.get(row).get(symbol));

        if(rowMaps.get(row).get(symbol) == board.getSize()){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Moves move) {
        int row = move.getCell().getRow();;
        Symbol symbol = move.getPlayer().getSymbol();

        rowMaps.get(row).put(
            symbol,
            rowMaps.get(row).get(symbol) - 1
        );
    }
}

// {x:0 y: 0} |
// {x: 0 y: 0} |
// {x: 0 y :0} |
