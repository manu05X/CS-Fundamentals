package com.manish.LLD.TicTacToe.strategy;

import com.manish.LLD.TicTacToe.model.Board;

public interface MoveStrategy {
    boolean isValidMove(Board board, int x, int y);
}
