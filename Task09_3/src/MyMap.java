public class MyMap implements Comparable<MyMap>{
    private char symbol;
    private double quantity;

    public MyMap(char symbol, double quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return symbol + " - " + quantity + "\n";
    }

    @Override
    public int compareTo(MyMap other) {
        return Double.compare(quantity,other.quantity);
    }
}
