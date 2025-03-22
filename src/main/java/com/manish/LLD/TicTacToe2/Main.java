package com.manish.LLD.TicTacToe2;

import com.manish.LLD.TicTacToe2.controllers.GameController;
import com.manish.LLD.TicTacToe2.exceptions.InvalidGameParamsException;
import com.manish.LLD.TicTacToe2.models.*;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.OrderOneColumnWinningStrategy;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Create a Game
        //Game controller
        GameController gameController = new GameController();
        //Input Taker
        Scanner scanner = new Scanner(System.in);

        //Create Object of Game
        Game game;
        List<Player> players = List.of(
                new Player(new Symbol('X'), "Naman", PlayerType.HUMAN),
                new Bot(new Symbol('O'), "Aman", BotDifficultyLevel.EASY)
        );
        int dimension = 3;

        try {
            game = gameController.createGame(
                    dimension,
                    players,
                    List.of(
                            new OrderOneDiagonalWinningStrategy(players),
                            new OrderOneColumnWinningStrategy(dimension, players),
                            new OrderOneRowWinningStrategy(dimension, players)
                    )
            );
        } catch (InvalidGameParamsException e) {
            System.out.println("Seems like you gave invalid params. Update those.");
            return;
        }


        //        Game.Builder gameBuilder = new Game.Builder();
        System.out.println("-------------- Game is starting --------------");

        boolean isFirstMove = true;

        //While game status in progress
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS))
        {
            System.out.println("This is how board looks like:");
            // print the board
            gameController.displayBoard(game);

            //print if UNDO
            System.out.println("Do you want to UNDO? (Y/N)");
            //if yes -> call UNDO
            String input = scanner.next();

            if(input.equalsIgnoreCase("y")){
                gameController.undo(game);
            } else {
                // move next Player
                gameController.makeMove(game);
            }

        }

        // check status of game

        gameController.printResult(game);
        gameController.displayBoard(game);

    }
}


/*
package com.manish.LLD.TicTacToe2;

import com.manish.LLD.TicTacToe2.controllers.GameController;
import com.manish.LLD.TicTacToe2.exceptions.InvalidGameParamsException;
import com.manish.LLD.TicTacToe2.models.*;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.OrderOneColumnWinningStrategy;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Create a Game
        //Game controller
        GameController gameController = new GameController();
        //Input Taker
        Scanner scanner = new Scanner(System.in);

        //Create Object of Game
        Game game;
        List<Player> players = List.of(
                new Player(new Symbol('X'), "Naman", PlayerType.HUMAN),
                new Bot(new Symbol('O'), "Aman", BotDifficultyLevel.EASY)
        );
        int dimension = 3;

        try {
            game = gameController.createGame(
                    dimension,
                    players,
                    List.of(
                            new OrderOneDiagonalWinningStrategy(players),
                            new OrderOneColumnWinningStrategy(dimension, players),
                            new OrderOneRowWinningStrategy(dimension, players)
                    )
            );
        } catch (InvalidGameParamsException e) {
            System.out.println("Seems like you gave invalid params. Update those.");
            return;
        }

        System.out.println("-------------- Game is starting --------------");

        boolean isFirstMove = true;

        //While game status in progress
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is how board looks like:");
            // print the board
            gameController.displayBoard(game);

            if (isFirstMove) {
                // If it's the first move, prompt the user to input their move
                System.out.println("Enter your move (row column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                gameController.makeMove(game, row, col);
                isFirstMove = false;
            } else {
                // After the first move, give the option to UNDO or make the next move
                System.out.println("Do you want to UNDO? (Y/N)");
                String input = scanner.next();

                if (input.equalsIgnoreCase("y")) {
                    gameController.undo(game);
                } else {
                    // move next Player
                    gameController.makeMove(game);
                }
            }
        }

        // check status of game
        gameController.printResult(game);
        gameController.displayBoard(game);
    }
}

 */


/*

//Create a Game Controller
//While game status in progress
        // print the board
        //print if UNDO
        //if yes -> call UNDO

        // move next Player

//Check Status of Game
   // if winner -> Print winner
   //else -> Print Draw

*/
