package calculator;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner;

    public Calculator() {
    }

    public static void main(String[] args) {
        int num1 = getInt();
        char operation = getOperation();
        int num2 = getInt();
        int result = calc(num1, num2, operation);
        System.out.println(result);

    }

    public static int getInt() {
        int num = 0;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        }
        if (num < 0 || num > 10) {
            throw new IllegalArgumentException();
        }


        return num;
    }

    public static char getOperation() {
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }

        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '*' -> result = num1 * num2;
            case '+' -> result = num1 + num2;
            case ',', '.' -> {
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
            }
            default -> {
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
            }
            case '-' -> result = num1 - num2;
            case '/' -> result = num1 / num2;
        }

        return result;
    }

    static {
        scanner = new Scanner(System.in);
    }
}
