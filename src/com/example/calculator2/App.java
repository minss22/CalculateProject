package com.example.calculator2;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        Scanner sc = new Scanner(System.in);
        String answer = "";

        do { // 반복문
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int n1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int n2 = sc.nextInt();
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                String symbol = sc.next();

                if (n1 < 0 || n2 < 0) { // 양의 정수(0 포함)를 입력받기
                    throw new RuntimeException("⚠️양의 정수를 입력해주세요.");
                }

                double result = cal.calculate(n1, n2, symbol);
                String result_str = (result % 1 == 0) ? String.format("%.0f", result) : String.valueOf(result);
                System.out.printf("결과: %d %s %d = %s\n", n1, symbol, n2, result_str);

                cal.setResult(result_str); // 세터
                if (cal.getResult().size() > 1)
                    cal.removeResult();
                System.out.println("클래스에 저장된 결과: " + cal.getResult()); // 게터
            } catch (RuntimeException e) { // 예외 처리
                System.out.println(e.getMessage());
            }

            System.out.println("\n더 계산하려면 아무 키나 입력해주세요. (exit 입력 시 종료)");
            sc.nextLine(); // 개행문자 제거
            answer = sc.nextLine(); // 개행문자도 인식
        } while (!answer.equals("exit"));
    }
}
