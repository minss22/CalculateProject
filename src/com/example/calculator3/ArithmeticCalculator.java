package com.example.calculator3;
import java.util.ArrayList;

public class ArithmeticCalculator {
    private ArrayList<String> list_result = new ArrayList<>();

    public double calculate(int n1, int n2, String symbol) {
        if (OperatorType.PLUS.getSymbol().equals(symbol)) {
            return n1 + n2;
        } else if (OperatorType.MINUS.getSymbol().equals(symbol)) {
            return n1 - n2;
        } else if (OperatorType.MULTIPLY.getSymbol().equals(symbol)) {
            return n1 * n2;
        } else if (OperatorType.DIVIDE.getSymbol().equals(symbol)) {
            if (n2 == 0) {
                throw new RuntimeException("️⚠️나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            return (double) n1 / n2;
        } else {
            throw new RuntimeException("️⚠️사칙연산 기호를 잘못 입력했습니다.");
        }
    }

    public ArrayList<String> getResult() {
        return list_result;
    }

    public void setResult(String result) {
        this.list_result.add(result); // 데이터 추가
    }

    public void removeResult() {
        this.list_result.remove(0); // 먼저 저장된 데이터 삭제
    }
}
