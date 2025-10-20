package com.example.calculator3;
import java.util.ArrayList;

public class ArithmeticCalculator {
    private ArrayList<String> list_result = new ArrayList<>();

    public <S extends Number> double calculate(S x, S y, String symbol) {
        double n1 = x.doubleValue();
        double n2 = y.doubleValue();

        for (OperatorType op : OperatorType.values()) { // 모든 객체를 순서대로 불러옴
            if (op.getSymbol().equals(symbol)) { // 기호가 같으면
                return op.apply(n1, n2); // 연산 후 리턴
            }
        }
        throw new RuntimeException("️⚠️사칙연산 기호를 잘못 입력했습니다.");
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
