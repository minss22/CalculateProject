package com.example.calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String answer;
        do { // ✅ do-while 반복문
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int n1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int n2 = sc.nextInt();
                System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                String symbol = sc.next();

                if (n1 < 0 || n2 < 0) {
                    throw new RuntimeException("⚠️양의 정수를 입력해주세요.");
                }
                double result = switch (symbol) { // ✅ 향상된 switch 문으로 계산 결과 받기
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

                System.out.printf("결과: %d %s %d = %s", n1, symbol, n2, result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()); // ✅ 예외 처리 메시지
            }
            System.out.println("\n\n더 계산하려면 아무 키나 입력해주세요. (exit 입력 시 종료)");
            sc.nextLine(); // 개행문자 제거
            answer = sc.nextLine(); // 개행문자도 인식
        } while (!answer.equals("exit")); // ✅ exit 입력 시 종료
    }
}
