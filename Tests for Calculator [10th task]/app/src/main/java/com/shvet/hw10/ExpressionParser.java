package com.shvet.hw10;

import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {
    public String makeStringFromExpression(Expression expr) {
        try {
            Double result = expr.evaluate();
            if (result == (result.intValue())) {
                return String.valueOf(result.intValue());
            } else {
                return String.valueOf(result);
            }
        } catch (Exception e) {
            return "Infinity";
        }
    }

    public Expression parse(String expression) throws Exception {
        List<Lexeme> lexemes = lexemeAnalyze(expression);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        return parseExpression(lexemeBuffer);
    }

    private Expression parseExpression(LexemeBuffer lexemes) throws Exception {
        Lexeme lexeme = lexemes.next();

        if (lexeme.type == LexemeType.EOF) {
            return new Const("0");
        } else {
            lexemes.back();
            return parseAdd(lexemes);
        }
    }

    public Expression parseAdd(LexemeBuffer lexemes) throws Exception {
        Expression value = parseMultiply(lexemes);

        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case ADD:
                    value = new Add(value, parseMultiply(lexemes));
                    continue;
                case SUBTRACT:
                    value = new Subtract(value, parseMultiply(lexemes));
                    continue;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    private Expression parseMultiply(LexemeBuffer lexemes) throws Exception {
        Expression value = parseFactor(lexemes);

        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case MULTIPLY:
                    value = new Multiply(value, parseFactor(lexemes));
                    continue;
                case DIVIDE:
                    value = new Divide(value, parseFactor(lexemes));
                    continue;
                case EXP:
                    value = new Exp(value, parseFactor(lexemes));
                    continue;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    private Expression parseFactor(LexemeBuffer lexemes) throws Exception {
        Lexeme lexeme = lexemes.next();

        switch (lexeme.type) {
            case NEGATE:
                return new Negate(parseFactor(lexemes));
            case NUMBER:
                try {
                    return new Const(lexeme.value);
                } catch (NumberFormatException e) {
                    throw new Exception("Not allowed format");
                }
            default:
                throw new Exception("Not allowed format");
        }
    }

    public enum LexemeType {
        NUMBER,
        NEGATE,
        ADD, SUBTRACT,
        MULTIPLY, DIVIDE,
        EOF,
        EXP
    }

    public static class Lexeme {
        LexemeType type;
        String value;

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }
    }

    private List<Lexeme> lexemeAnalyze(final String expressionText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;

        while (pos < expressionText.length()) {
            char c = expressionText.charAt(pos);

            switch (c) {
                case '+':
                    lexemes.add(new Lexeme(LexemeType.ADD, c));
                    pos++;
                    continue;
                case '-':
                    if (pos == 0) {
                        lexemes.add(new Lexeme(LexemeType.NEGATE, c));
                        pos++;
                        continue;
                    }

                    lexemes.add(new Lexeme(LexemeType.SUBTRACT, c));
                    pos++;
                    continue;
                case '^':
                    lexemes.add(new Lexeme(LexemeType.EXP, c));
                    pos++;
                    continue;
                case 'X':
                    lexemes.add(new Lexeme(LexemeType.MULTIPLY, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.DIVIDE, c));
                    pos++;
                    continue;
                default:
                    String number = takeNumber(expressionText, pos);
                    while (pos < expressionText.length() && (('0' <= expressionText.charAt(pos)
                            && expressionText.charAt(pos) <= '9')
                            || expressionText.charAt(pos) == '.')) {
                        pos++;
                    }

                    lexemes.add(new Lexeme(LexemeType.NUMBER, number));
            }
        }

        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    private static String takeNumber(String expressionText, int pos) {
        char c = expressionText.charAt(pos);
        StringBuilder number = new StringBuilder();

        if (c == '-') {
            number.append(c);
            pos++;
            c = expressionText.charAt(pos);
        }
        do {
            number.append(c);
            pos++;
            if (pos == expressionText.length()) {
                break;
            }
            c = expressionText.charAt(pos);
        } while (c >= '0' && c <= '9' || c == '.');

        return number.toString();
    }

    public static class LexemeBuffer {
        private int pos;

        private final List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }
    }
}
