package com.manish.LLD.TicTacToe.factory;

import com.manish.LLD.TicTacToe.model.HumanPlayer;
import com.manish.LLD.TicTacToe.model.Player;

public class PlayerFactory {
    public static Player createPlayer(char symbol){
        return new HumanPlayer(symbol);
    }
}
