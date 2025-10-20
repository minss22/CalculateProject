package com.example.calculator3;
import java.util.function.DoubleBinaryOperator;

public enum OperatorType {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol; // 사칙연산 기호
    private final DoubleBinaryOperator op; // 람다식 저장

    OperatorType(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public String getSymbol() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
