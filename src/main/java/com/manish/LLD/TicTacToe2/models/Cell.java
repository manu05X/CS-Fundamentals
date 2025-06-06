package com.manish.LLD.TicTacToe2.models;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
            this.cellState = CellState.EMPTY;
        }

        public int getRow() {
            return row;
        }
        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public CellState getCellState() {
            return cellState;
        }

        public void setCellState(CellState cellState) {
            this.cellState = cellState;
        }

        public Player getPlayer() {
            return player;
        }
        public void setPlayer(Player player) {
            this.player = player;
        }


        public void display() {
            if (getCellState().equals(CellState.EMPTY)) {
                System.out.print(" - |");
            } else {
                System.out.print(" " + getPlayer().getSymbol().getaChar() + " |");
            }
        }

}
