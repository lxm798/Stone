package stone;

public class IdToken extends Token {
    private String text;
    protected IdToken(int line, String id) {
        super(line);
        text = id;
    }

    @Override
    public boolean isIdentifie() {
        return true;
    }

    @Override
    public String getText() {
        return text;
    }
}
