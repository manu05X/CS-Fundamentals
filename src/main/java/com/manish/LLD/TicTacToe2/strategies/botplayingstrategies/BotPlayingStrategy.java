package com.manish.LLD.TicTacToe2.strategies.botplayingstrategies;


import com.manish.LLD.TicTacToe2.models.Board;
import com.manish.LLD.TicTacToe2.models.Cell;

public interface BotPlayingStrategy {
    Cell makeMove(Board board);
}
