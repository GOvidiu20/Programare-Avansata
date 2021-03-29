import java.util.List;

public class Token {
    private int first;
    private int second;
    private int value;
    public Token(int first, int second, int value) {
        this.first = first;
        this.second = second;
        this.value = value;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
