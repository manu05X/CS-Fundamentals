package com.manish.LLD.TicTacToe.model;

import com.manish.LLD.TicTacToe.controller.GameController;
import com.manish.LLD.TicTacToe.factory.PlayerFactory;
import com.manish.LLD.TicTacToe.strategy.DefaultMoveStrategy;
import com.manish.LLD.TicTacToe.strategy.DefaultWinStrategy;
import com.manish.LLD.TicTacToe.strategy.MoveStrategy;
import com.manish.LLD.TicTacToe.strategy.WinStrategy;

import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    private MoveStrategy moveStrategy;
    private WinStrategy winStrategy;

    public TicTacToe(){
        GameController gameController = GameController.getInstance();
        board = new Board(3);
        player1 = PlayerFactory.createPlayer('X');
        player2 = PlayerFactory.createPlayer('O');

        currentPlayer = player1;

        moveStrategy = new DefaultMoveStrategy();
        winStrategy = new DefaultWinStrategy();

        board.addObserver(player1);
        board.addObserver(player2);
    }

    public void playGame(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Player "+ currentPlayer.getSymbol() + "'s turn");
            System.out.println("Enter row (0,1, or 2): ");

            int x = sc.nextInt();
            System.out.println("Enter row (0,1, or 2): ");
            int y = sc.nextInt();

            if(moveStrategy.isValidMove(board, x, y)){
                board.updateBoard(x,y, currentPlayer.getSymbol());

                if(winStrategy.checkWin(board, currentPlayer.getSymbol())){
                    System.out.println("Player "+ currentPlayer.getSymbol() + " wins!");
                    break;
                }

                if(isDraw()){
                    System.out.println("Game is a draw!");
                    break;
                }

                switchPlayer ();
            } else {
                System.out.println("Invalid move! Try again");
            }
        }

        sc.close();
    }

    public void switchPlayer(){
        currentPlayer = (currentPlayer == player1) ? player2 : player2;
    }

    private boolean isDraw(){
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                if(board.getCell(i,j) == '\0'){
                    return false;
                }
            }
        }
        return true;
    }

}
