package stone;

public class StrToken extends Token {
    private String literal;
    protected StrToken(int line, String str) {
        super(line);
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getText() {
        return literal;
    }
}
