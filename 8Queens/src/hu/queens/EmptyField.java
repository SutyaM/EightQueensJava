package hu.queens;

public class EmptyField extends Field{

    String symbol;

    public EmptyField (int x, int y) {
        super(x, y);
        this.symbol = "[ ]";
    }
}
