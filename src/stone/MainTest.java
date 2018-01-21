package stone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;

public class MainTest {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Reader reader = new InputStreamReader(new FileInputStream("/home/ly/test.stone"));
        Lexer lexer = new Lexer(reader);
        Token token = null;
        while ((token = lexer.read()) != Token.EOF) {
            System.out.println(token.getLineNumber() + " " + (token.isNumber() ? token.getNumber() : token.getText()));
        }
    }

}
