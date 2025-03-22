package com.manish.LLD.TicTacToe.strategy;

import com.manish.LLD.TicTacToe.model.Board;

public class DefaultMoveStrategy implements MoveStrategy{
    @Override
    public boolean isValidMove(Board board, int x, int y) {
        return board.getCell(x, y) == '\0';
    }
}
