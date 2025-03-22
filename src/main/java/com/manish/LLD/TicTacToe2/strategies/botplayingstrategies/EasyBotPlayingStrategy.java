package com.manish.LLD.TicTacToe2.strategies.botplayingstrategies;




import com.manish.LLD.TicTacToe2.models.Board;
import com.manish.LLD.TicTacToe2.models.Cell;
import com.manish.LLD.TicTacToe2.models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Cell makeMove(Board board) {
        for (List<Cell> row: board.getBoard()) {
            for (Cell cell: row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return cell;
                }
            }
        }

        return null; // You should never come here
    }
}
