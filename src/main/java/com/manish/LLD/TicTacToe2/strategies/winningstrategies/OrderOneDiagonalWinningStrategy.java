package com.manish.LLD.TicTacToe2.strategies.winningstrategies;



import com.manish.LLD.TicTacToe2.models.Board;
import com.manish.LLD.TicTacToe2.models.Moves;
import com.manish.LLD.TicTacToe2.models.Player;
import com.manish.LLD.TicTacToe2.models.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneDiagonalWinningStrategy implements WinningStrategy {
    private final Map<Symbol, Integer> leftDiagMap;
    private final Map<Symbol, Integer> rightDiagMap;

    public OrderOneDiagonalWinningStrategy(List<Player> players) {
        leftDiagMap = new HashMap<>();
        rightDiagMap = new HashMap<>();

        for (Player player: players) {
            leftDiagMap.put(player.getSymbol(), 0);
            rightDiagMap.put(player.getSymbol(), 0);
        }
    }

    @Override
    public boolean checkWinning(Board board, Moves move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDiagMap.put(symbol, leftDiagMap.get(symbol) + 1);
        }

        if (row + col == board.getSize() - 1) {
            rightDiagMap.put(symbol, rightDiagMap.get(symbol) + 1);
        }

        if (row == col) {
            if (leftDiagMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        if (row + col == board.getSize() - 1) {
            if (rightDiagMap.get(symbol) == board.getSize()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Moves move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row == col) {
            leftDiagMap.put(
                symbol, leftDiagMap.get(symbol) - 1
            );
        }

        if (row + col == board.getSize() - 1) {
            rightDiagMap.put(
                    symbol, rightDiagMap.get(symbol) - 1
            );
        }
    }
}
