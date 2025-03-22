package com.manish.LLD.TicTacToe.strategy;

import com.manish.LLD.TicTacToe.model.Board;

public interface WinStrategy {
    boolean checkWin(Board board, char symbol);
}
