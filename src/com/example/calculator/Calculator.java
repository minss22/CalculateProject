package com.example.calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] symbols = {"+", "-", "*", "/"};
        double result = 0;

        try {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int n1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int n2 = sc.nextInt();
            System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
            String symbol = sc.next();

            switch (symbol) {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    if (n2 == 0) {
                        throw new RuntimeException();
                    }
                    result = n1 / (double) n2;
            }

            System.out.printf("사칙연산의 결과: %d %s %d = %s", n1, symbol, n2, result);
        } catch (RuntimeException e) {
            System.out.println("⚠️나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }

    }
}
