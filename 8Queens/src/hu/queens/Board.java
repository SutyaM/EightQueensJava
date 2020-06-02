package hu.queens;

import java.util.Optional;

public class Board {

    int row;
    int col;
    Field[][] board;

    public Board (int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new Field[row][col];
    }

    public void buildBoard () {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = new EmptyField(i, j);
            }
        }
    }

    public Optional<Boolean> checkForQueen(int row, int col) {

        for (int i = 0; i < this.board.length; i++) {
            if (this.board[i][col] instanceof Queen) {
                return Optional.of(false);
            }
        }

        for (int j = 0; j < this.board.length; j++) {
            if (this.board[row][j] instanceof Queen) {
                return Optional.of(false);
            }
        }

        for (int i = row, j = col; i < this.board.length && j < this.board.length; i++, j++) {
            if (this.board[i][j] instanceof Queen) {
                return Optional.of(false);
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (this.board[i][j] instanceof Queen) {
                return Optional.of(false);
            }
        }

        for (int i = row, j = col; i >= 0 && j < this.board.length; i--, j++) {
            if (this.board[i][j] instanceof Queen) {
                return Optional.of(false);
            }
        }

        for (int i = row, j = col; i < this.board.length && j >= 0; i++, j--) {
            if (this.board[i][j] instanceof Queen) {
                return Optional.of(false);
            }
        }
        
        return Optional.of(true);
    }

    public boolean placeQueen (int number) {
        if(number >= this.col) {
            return true;
        } else {
            for (int i = 0; i < this.col; i++) {
                boolean bool = checkForQueen(i, number).orElse(null);
                if (bool) {
                    this.board[i][number] = new Queen(i, number);
                   if (placeQueen(number + 1)) {
                       return true;
                   } else {
                       this.board[i][number] = new EmptyField(i, number);
                   }
                }
            }
        }
        return false;
    }

    public void printBoard() {
        String line ="";
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] instanceof EmptyField) {
                    EmptyField emptyField = (EmptyField) this.board[i][j];
                    line += emptyField.symbol;
                } else if (this.board[i][j] instanceof Queen) {
                    Queen queen = (Queen) this.board[i][j];
                    line += queen.symbol;
                }
            }
            System.out.println(line);
            line = "";
        }
    }

}