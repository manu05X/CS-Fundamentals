package com.manish.LLD.TicTacToe2.models;





import com.manish.LLD.TicTacToe2.exceptions.InvalidGameParamsException;
import com.manish.LLD.TicTacToe2.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Moves> moves;
    private int currentMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private GameStatus gameStatus;
    private Player winnerPlayer;

    public static Builder getBuilder() {
        return new Builder();
    }

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.moves = new ArrayList<>();
        this.board = new Board(dimension);
        this.players = players;
        this.currentMovePlayerIndex = 0;
        this.winningStrategies = winningStrategies;
        this.gameStatus = GameStatus.IN_PROGRESS;
//        this.winner = null;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentMovePlayerIndex() {
        return currentMovePlayerIndex;
    }

    public void setCurrentMovePlayerIndex(int currentMovePlayerIndex) {
        this.currentMovePlayerIndex = currentMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winnerPlayer;
    }

    public void setWinner(Player winner) {
        this.winnerPlayer = winnerPlayer;
    }

    public void printBoard() { this.board.print(); }

//    public void printWinner() {
//        System.out.println(winnerPlayer);
//    }

    public void printResult(){
        if(gameStatus.equals(GameStatus.ENDED)) {
            System.out.println("Game Ended");
            System.out.println("Winner is " + winnerPlayer.getName());
        }
        else {
            System.out.println("Game Draw");
        }
    }


    //Checking cell for correct Move
    private boolean validateMove(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        if (row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()) {
            return false;
        }

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);

    }

    //reverse of make move
    public void undo() {
        if (moves.size() == 0) {
            System.out.println("No move. Can't undo.");
            return;
        }

        //Getting the Cell for undo from move list
        Moves lastMove = moves.get(moves.size() - 1);

        for (WinningStrategy winningStrategy: winningStrategies) {
            winningStrategy.handleUndo(board, lastMove);
        }

        Cell cellInBoard = lastMove.getCell();
        cellInBoard.setCellState(CellState.EMPTY);
        cellInBoard.setPlayer(null);

        moves.remove(lastMove);

        currentMovePlayerIndex -= 1;
        currentMovePlayerIndex += players.size();// before mode we must add prev num first as after mode it can become less than 0
        // [A B C D]
        // ^
        // 0
        // -1
        // -1 % 4 == -1
        // (-1 + 4) == 3
        // 3 % 4 == 3
        currentMovePlayerIndex %= players.size();
    }



    public void makeMove() {
        //Current player
        Player currentPlayer = players.get(currentMovePlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");

        //The proposeCell to make move so it must have access to the board obj as moves are made on it
        Cell proposedCell = currentPlayer.makeMove(board);

        System.out.println("Move made at row: " + proposedCell.getRow() +
                " col: " + proposedCell.getCol() + ".");

        if (!validateMove(proposedCell)) {
            System.out.println("Invalid move. Please Try Again.");
            return;
        }

        //update the move now after validation
        Cell cellInBoard = board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellInBoard.setCellState(CellState.FILLED);
        cellInBoard.setPlayer(currentPlayer);

        Moves move = new Moves(currentPlayer, cellInBoard);
        moves.add(move);

        //Checking for winner
        if (checkGameWon(currentPlayer, move)) return;
        //checking for draw
        if (checkDraw()) return;


        currentMovePlayerIndex += 1;
        currentMovePlayerIndex %= players.size();

    }

    private boolean checkDraw() {
        if (moves.size() == board.getSize() * board.getSize()) {
            gameStatus = GameStatus.DRAW;
            return true;
        }
        return false;
    }

    private boolean checkGameWon(Player currentPlayer, Moves move) {
        for (WinningStrategy winningStrategy: winningStrategies) {
            if (winningStrategy.checkWinning(board, move)) {
                gameStatus = GameStatus.ENDED;
                winnerPlayer = currentPlayer;
                return true;
            }
        }
        return false;
    }






    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        //builder dont have public constructor.
        //How do we get object of builder?
        // Ans -> Via a static method of parent class that implements it here its game.
        private Builder(){}

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this; //return this-> Allow for chaining
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        // Validating the parameters and attributes of game
        private boolean valid() {

            //players count validation that it must be > 1
            if (this.players.size() < 2) {
                return false;
            }

            if (this.players.size() != this.dimension - 1) {
                return false;
            }

            //dimension validation
            int botCount = 0;

            for (Player player: this.players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount += 1;
                }
            }

            if (botCount >= 2) {
                return false;
            }

            //Symbol validation
            Set<Character> existingSymbols = new HashSet<>();

            //Going to each player symbol
            for (Player player: players) {
                if (existingSymbols.contains(player.getSymbol().getaChar())) {
                    return false;
                }

                existingSymbols.add(player.getSymbol().getaChar());
            }

            return true;
        }

        public Game build() throws InvalidGameParamsException {
            if (!valid()) {
                throw new InvalidGameParamsException("Invalid params for game");
            }
            return new Game(
                    dimension, players, winningStrategies
            );
        }
    }
}
