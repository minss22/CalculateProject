package com.example.calculator2;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<Double> list_result = new ArrayList<>();

    public double calculate(int n1, int n2, String symbol) {
        double result = switch (symbol) { // 계산 결과
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> {
                if (n2 == 0) {
                    throw new RuntimeException("️⚠️나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                yield n1 / (double) n2;
            }
            default -> throw new RuntimeException("️⚠️사칙연산 기호를 잘못 입력했습니다.");
        };
        return result;
    }

    public ArrayList<Double> getResult() {
        return list_result;
    }

    public void setResult(double result) {
        this.list_result.add(result); // 데이터 추가
    }

    public void removeResult() {
        this.list_result.remove(0); // 가장 먼저 저장된 데이터 삭제
    }
}
