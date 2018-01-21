package stone;

public class NumToken extends Token {
    private int value;
    protected NumToken(int line, int v) {
        super(line);
        value = v;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public int getNumber() {
        return value;
    }

    @Override
    public String getText() {
        return Integer.toString(value);
    }
}
