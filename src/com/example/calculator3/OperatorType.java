package com.example.calculator3;
import java.util.function.DoubleBinaryOperator; // 함수형 인터페이스

public enum OperatorType {
    PLUS("+", (x, y) -> x + y), // ✅ 추상 메서드를 구체화
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) { // ❌ 나눗셈에서 분모에 0 입력 시 예외 처리
            throw new RuntimeException("️⚠️나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
        return x / y;
    });

    private final String symbol; // 사칙연산 기호
    private final DoubleBinaryOperator op; // 람다식

    OperatorType(String symbol, DoubleBinaryOperator op) { // 생성자를 통해 기호와 람다식 저장
        this.symbol = symbol;
        this.op = op;
    }

    public String getSymbol() { // Getter
        return symbol;
    }

    public double apply(double x, double y) { // ✅ 추상 메서드
        return op.applyAsDouble(x, y); // 두 개의 double 값을 받아서, 하나의 double 결과를 반환하는 함수
    }
}
