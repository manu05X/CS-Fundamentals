package com.manish.LLD.TicTacToe2.strategies.winningstrategies;


import com.manish.LLD.TicTacToe2.models.Board;
import com.manish.LLD.TicTacToe2.models.Moves;

public interface WinningStrategy {
    boolean checkWinning(Board board, Moves move);
    void handleUndo(Board board, Moves move);

}
