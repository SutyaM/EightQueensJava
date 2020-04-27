package hu.queens;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Board board = new Board(8, 8);
        board.buildBoard();

        board.placeQueen(0);

        board.printBoard();

    }
}
