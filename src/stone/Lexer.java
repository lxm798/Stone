package stone;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    public static String regexPat = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\n|[^\"])*\")"
            + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
/*    public static String regexPat = "\\s*([A-Z_a-z][A-Z_a-z0-9]*)?";*/
    private Pattern pattern = Pattern.compile(regexPat);
    private List<Token> queue = new ArrayList<>(10);
    private boolean hasMore;
    private LineNumberReader reader;
    public Lexer(Reader reader) {
        hasMore = true;
        this.reader = new LineNumberReader(reader);
    }
    public Token read() throws ParseException {
        while (queue.size() == 0 && hasMore) {
            readLine();
        }
        return queue.size() == 0 ? Token.EOF : queue.remove(0);
    }

    private void readLine() throws ParseException {
        String line = null;
        try {
            if ((line = reader.readLine()) == null) {
                hasMore = false;
                return;
            }
            parseToken(line, reader.getLineNumber());
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }
    private void parseToken(String line, int lineNo) throws ParseException {
        Matcher matcher = pattern.matcher(line);
        matcher.useTransparentBounds(true).useAnchoringBounds(false);
        int pos = 0;
        int endPos = line.length();
        while (pos < endPos) {
            matcher.region(pos, endPos);
            if (matcher.lookingAt()) {
                addToken(lineNo, matcher);
                pos = matcher.end();
            } else {
                throw new ParseException("parse error", lineNo);
            }
        }
        queue.add(new IdToken(lineNo, Token.EOL));
    }
    private void addToken(int lineNo, Matcher matcher) {
        String m0 = matcher.group(0);
        String m = matcher.group(1);
/*        String m3 = matcher.group(3);
        String m4 = matcher.group(4);*/
        if (m != null) {
            if (matcher.group(2) == null) {
                Token token;
                if (matcher.group(3) != null) {
                    token = new NumToken(lineNo, Integer.parseInt(m));
                } else if  (matcher.group(4) != null) {
                    token = new StrToken(lineNo, toStringLiteral(m));
                } else {
                    token = new IdToken(lineNo, m);
                }
                queue.add(token);
            }
        }
    }
    private String toStringLiteral(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i =0 ; i< s.length(); ++i) {
            if (s.charAt(i) == '\\' && i + 1 < s.length()) {
                int c2 = s.charAt(i+1);
                if (c2 == '"' || c2 == '\\') {
                    builder.append(s.charAt(++i));
                } else if (c2 == 'n') {
                    ++i;
                    builder.append('\n');
                }
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
