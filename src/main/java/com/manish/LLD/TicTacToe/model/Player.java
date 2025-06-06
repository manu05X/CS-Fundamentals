package com.manish.LLD.TicTacToe.model;

public abstract class Player {
    protected char symbol;

    public char getSymbol(){
        return symbol;
    }

    public abstract void makeMove(Board board);
}
