package com.example.calculator3;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private ArrayList<String> list_result = new ArrayList<>();

    public <S extends Number> double calculate(S x, S y, String symbol) { // ✅ 제네릭 활용
        double n1 = x.doubleValue();
        double n2 = y.doubleValue();

        for (OperatorType op : OperatorType.values()) { // 모든 객체를 순서대로 불러옴
            if (op.getSymbol().equals(symbol)) { // 기호가 같으면
                return op.apply(n1, n2); // ✅ 연산 후 리턴 (enum 메서드를 이용)
            }
        }
        throw new RuntimeException("️⚠️사칙연산 기호를 잘못 입력했습니다."); // ❌ 기호 잘못 입력 시 예외 처리
    }

    public ArrayList<String> getResult() { // Getter
        return list_result;
    }

    public void setResult(String result) { // Setter
        this.list_result.add(result); // ✅ 데이터 추가
    }

    public void removeResult() { // ✅ 먼저 저장된 데이터 삭제
        this.list_result.remove(0);
    }

    public List<String> searchResult(double n) { // ✅ 특정 값보다 큰 데이터 반환
        return list_result.stream().filter(x -> Double.parseDouble(x) > n).toList(); // ✅ 스트림 & 람다식 적용
    }
}
