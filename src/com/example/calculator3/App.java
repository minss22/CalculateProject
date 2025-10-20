package com.example.calculator3;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator cal = new ArithmeticCalculator();
        Scanner sc = new Scanner(System.in);
        String answer = "";

        do { // 반복문
            try {
                if (answer.equals("del")) {
                    if (!cal.getResult().isEmpty())
                        cal.removeResult(); // 데이터 삭제
                } else if (answer.equals("search")) {
                    System.out.println("\n컬렉션에서 입력된 값보다 큰 결과값을 조회할 수 있습니다.");
                    System.out.print("값을 입력하세요: ");
                    String input = sc.nextLine();
                    double n = Double.parseDouble(input);

                    List<String> bigger = cal.getResult().stream()
                            .filter(x -> Double.parseDouble(x) > n).toList();
                    System.out.println("결과: " + bigger);
                } else {
                    System.out.println("==========[계산기]==========");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    String input1 = sc.nextLine();
                    double n1 = Double.parseDouble(input1);
                    if (n1 < 0) throw new RuntimeException("⚠️0 이상의 수를 입력해주세요.");

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    String input2 = sc.nextLine();
                    double n2 = Double.parseDouble(input2);
                    if (n2 < 0) throw new RuntimeException("⚠️0 이상의 수를 입력해주세요.");

                    System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                    String symbol = sc.nextLine(); // 개행문자 제거

                    double result = cal.calculate(n1, n2, symbol); // 컬렉션 첫번째 값 제거

                    String n1_str = (n1 % 1 == 0) ? String.format("%.0f", n1) : String.valueOf(n1);
                    String n2_str = (n2 % 1 == 0) ? String.format("%.0f", n2) : String.valueOf(n2);
                    String result_str = (result % 1 == 0) ? String.format("%.0f", result) : String.valueOf(result);
                    System.out.printf("결과: %s %s %s = %s\n", n1_str, symbol, n2_str, result_str);

                    cal.setResult(result_str); // 세터
                }
                System.out.println("컬렉션: " + cal.getResult()); // 게터
            } catch (NumberFormatException e) {
                System.out.println("⚠️숫자만 입력할 수 있습니다.");
            } catch (RuntimeException e) { // 예외 처리
                System.out.println(e.getMessage());
            }

            System.out.println("\n더 계산하려면 아무 키나 입력해주세요.");
            System.out.println(" - (exit 입력 시 종료)");
            System.out.println(" - (del 입력 시 컬렉션 첫번째 데이터 삭제)");
            System.out.println(" - (search 입력 시 컬렉션 조회)");

            answer = sc.nextLine(); // 개행문자도 인식
        } while (!answer.equals("exit")); // 종료 아니면 반복
    }
}
