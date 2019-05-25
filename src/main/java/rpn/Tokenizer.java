package rpn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokenizer {

    public List<Token> tokenize(String mainExpression) {
        List<Token> tokens = new ArrayList<>();
        Arrays.stream(mainExpression.split(" "))
                .forEach(item -> tokens.add(new Token(item)));
        return tokens;
    }
}
