package com.example.calculator3;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator cal = new ArithmeticCalculator();
        Scanner sc = new Scanner(System.in);
        String answer = "";

        do { // ✅ do-while 반복문
            try { // ✅ try-catch
                if (answer.equals("del")) {
                    if (!cal.getResult().isEmpty())
                        cal.removeResult(); // 데이터 삭제
                } else if (answer.equals("search")) {
                    System.out.println("\n리스트에서 입력된 값보다 큰 결과값을 조회할 수 있습니다.");
                    System.out.print("값을 입력하세요: ");
                    String input = sc.nextLine();
                    double n = Double.parseDouble(input);

                    List<String> bigger = cal.getResult().stream()
                            .filter(x -> Double.parseDouble(x) > n).toList(); // ✅ 스트림 & 람다식 적용
                    System.out.println("결과: " + bigger);
                } else {
                    // ✅ 입력받기
                    System.out.println("==========[계산기]==========");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    String input1 = sc.nextLine(); // nextDouble()로 입력을 받으면 개행문자를 처리해야 하는 문제가 발생
                    double n1 = Double.parseDouble(input1); // ❌ 숫자 변환 실패 시 NumberFormatException 예외 처리
                    if (n1 < 0) throw new RuntimeException("⚠️0 이상의 수를 입력해주세요."); // ❌ 음수 입력 시 예외 처리

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    String input2 = sc.nextLine();
                    double n2 = Double.parseDouble(input2);
                    if (n2 < 0) throw new RuntimeException("⚠️0 이상의 수를 입력해주세요.");

                    System.out.print("사칙연산 기호(+, -, *, /)를 입력하세요: ");
                    String symbol = sc.nextLine();

                    // ✅ 계산하기
                    double result = cal.calculate(n1, n2, symbol);

                    // 소수점 없으면 정수처럼 표시
                    String n1_str = (n1 % 1 == 0) ? String.format("%.0f", n1) : String.valueOf(n1);
                    String n2_str = (n2 % 1 == 0) ? String.format("%.0f", n2) : String.valueOf(n2);
                    String result_str = (result % 1 == 0) ? String.format("%.0f", result) : String.valueOf(result);
                    System.out.printf("결과: %s %s %s = %s\n", n1_str, symbol, n2_str, result_str);

                    cal.setResult(result_str); // 세터 - 연산 결과 저장
                }
                System.out.println("리스트: " + cal.getResult()); // 게터
            } catch (NumberFormatException e) { // 숫자 변환 실패 시 예외 처리
                System.out.println("⚠️숫자만 입력할 수 있습니다.");
            } catch (RuntimeException e) { // 예외 처리
                System.out.println(e.getMessage());
            }

            System.out.println("\n더 계산하려면 아무 키나 입력해주세요.");
            System.out.println(" - (exit 입력 시 종료)");
            System.out.println(" - (del 입력 시 리스트 첫번째 데이터 삭제)");
            System.out.println(" - (search 입력 시 리스트 조회)");

            answer = sc.nextLine();
        } while (!answer.equals("exit")); // 종료 아니면 반복
    }
}
