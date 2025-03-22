package com.manish.LLD.TicTacToe2.models;


import com.manish.LLD.TicTacToe2.strategies.botplayingstrategies.BotPlayingStrategy;
import com.manish.LLD.TicTacToe2.strategies.botplayingstrategies.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    //For making move for bots
    private final BotPlayingStrategy botPlayingStrategy;

    public Bot(Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = (BotPlayingStrategy) BotPlayingStrategyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    // as we makeMove for bot but we also need access to board as moves are made on board
    @Override
    public Cell makeMove(Board board) {

        return botPlayingStrategy.makeMove(board);
    }
}
