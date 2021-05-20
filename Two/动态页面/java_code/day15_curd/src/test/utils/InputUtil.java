package test.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    private InputUtil() {
    }

    public static String input() {
        return scanner.next();
    }

    public static int inputInt() {
        return scanner.nextInt();
    }

    public static String input(String regex) {
        String str = scanner.next();
        if (str.matches(regex)) {
            return str;
        }
        while (!str.matches(regex)) {
            System.out.print("您的输入有误，请重新输入：");
            str = scanner.next();
        }
        return str;
    }

    public static String input(String regex, String message) {
        String str = scanner.next();
        if (str.matches(regex)) {
            return str;
        }
        while (!str.matches(regex)) {
            System.out.print(message);
            str = scanner.next();
        }
        return str;
    }

    public static BigDecimal nextMoney() {
        return scanner.nextBigDecimal();
    }
}
