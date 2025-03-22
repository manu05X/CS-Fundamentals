package com.manish.LLD.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] board;
    private List<Player> observer = new ArrayList<>();

    public Board(int size){
        board = new char[size][size];
    }

    public void addObserver(Player player){
        observer.add(player);
    }

    public void notifyObservers(){
        for (Player player : observer){
            player.makeMove(this);
        }
    }

    public void updateBoard(int x, int y, char symbol){
        board[x][y] = symbol;
        notifyObservers();
    }

    public char getCell(int x, int y){
        return board[x][y];
    }

    public int getSize(){
        return board.length;
    }
}
