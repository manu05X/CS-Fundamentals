package com.manish.LLD.TicTacToe2.controllers;


import com.manish.LLD.TicTacToe2.exceptions.InvalidGameParamsException;
import com.manish.LLD.TicTacToe2.models.Game;
import com.manish.LLD.TicTacToe2.models.GameStatus;
import com.manish.LLD.TicTacToe2.models.Player;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimension,
                           List<Player> players,
                           List<WinningStrategy> winningStrategies) throws InvalidGameParamsException {

        try {
            return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .build();
        } catch (InvalidGameParamsException e) {
            throw new RuntimeException(e);
        }

    }

    /*
        Client(i.e Main)-> GameController -> Game(models) -> Board -> Cell
    */
    public void displayBoard(Game game) {
        game.printBoard();
    }


    public void undo(Game game){
        game.undo();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

//    public void prinWinner(Game game){
//        game.printWinner();
//    }

    public void printResult(Game game){
        game.printResult();
    }


}
