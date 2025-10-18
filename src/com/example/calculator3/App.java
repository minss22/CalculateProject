package com.example.calculator3;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator cal = new ArithmeticCalculator();
        Scanner sc = new Scanner(System.in);
        String answer = "";

        do { // 반복문
            if (answer.equals("del")) {
                if (!cal.getResult().isEmpty())
                    cal.removeResult(); // 데이터 삭제
            } else {
                try {
                    System.out.println("==========[계산기]==========");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    double n1 = sc.nextDouble();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    double n2 = sc.nextDouble();
                    System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                    String symbol = sc.next();
                    sc.nextLine(); // 개행문자 제거

                    if (n1 < 0 || n2 < 0) { // 양의 정수(0 포함)를 입력받기
                        throw new RuntimeException("⚠️양의 정수를 입력해주세요.");
                    }

                    double result = cal.calculate(n1, n2, symbol);

                    String n1_str = (n1 % 1 == 0) ? String.format("%.0f", n1) : String.valueOf(n1);
                    String n2_str = (n2 % 1 == 0) ? String.format("%.0f", n2) : String.valueOf(n2);
                    String result_str = (result % 1 == 0) ? String.format("%.0f", result) : String.valueOf(result);
                    System.out.printf("결과: %s %s %s = %s\n", n1_str, symbol, n2_str, result_str);

                    cal.setResult(result_str); // 세터
                } catch (RuntimeException e) { // 예외 처리
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("컬렉션에 저장된 결과: " + cal.getResult()); // 게터

            System.out.println("\n더 계산하려면 아무 키나 입력해주세요.");
            System.out.println(" - (exit 입력 시 종료)");
            System.out.println(" - (del 입력 시 컬렉션 첫번째 데이터 삭제)");

            answer = sc.nextLine(); // 개행문자도 인식
        } while (!answer.equals("exit")); // 종료 아니면 반복
    }
}
