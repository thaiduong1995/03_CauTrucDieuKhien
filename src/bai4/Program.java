package bai4;

import bai3.PhanSo;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static boolean bai1(long n) {
        for (long i = n / 2; i > 1 ; i--) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long bai2(int n) {
        long result = 0;
        int count = 0;
        long primeNumber = 2;
        while (count < n) {
            if (bai1(primeNumber)) {
                count++;
                result += primeNumber;
            }
            primeNumber++;
        }
        return result;
    }

    public static String bai3() {
        String result = "";
        for (int i = 2; i <= 10; i++) {
            result += "Bảng " + i + "\n";
            for (int j = 1; j <= 10; j++) {
                result += String.format("%2d x %2d = %3d\n", i, j, i * j);
            }
            result += "---------------------------------\n";
        }
        return result;
    }

    public static double bai4(double x, int i) {
        double result = 0;
        if (i < 0) {
            result = -1;
        } else {
            for (int j = 0; j < i; j++) {
                result += Math.pow(x, 2 * j + 1) / bai3.Main.bai1(2 * j + 1);
            }
        }
        return result;
    }

    public static String bai5(int n) {
        long[] result = new long[n];
        result[0] = 1;
        result[1] = 1;
        if (n < 2) {
            return Arrays.toString(result);
        } else {
            for (int i = 2; i < n; i++) {
                result[i] = result[i-1] + result[i - 2];
            }
            return Arrays.toString(result);
        }
    }

    public static void main(String[] args) {
        int opt;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chương trình:");
            System.out.println("1. Giải bài 1");
            System.out.println("2. Giải bài 2");
            System.out.println("3. Giải bài 3");
            System.out.println("4. Giải bài 4");
            System.out.println("5. Giải bài 5");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Nhập n= ");
                    int number = Integer.parseInt(scanner.nextLine());
                    if (bai1(number)) {
                        System.out.println(number + " là số nguyên tố");
                    } else {
                        System.out.println(number + " không là số nguyên tố");
                    }
                    break;
                case 2:
                    System.out.print("Nhập n= ");
                    int n = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Tổng của %d số nguyên tố đầu tiên là %d\n", n, bai2(n));
                    break;
                case 3:
                    System.out.println(bai3());
                    break;
                case 4:
                    System.out.print("Nhập x= ");
                    double x = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập sai số epsilon i= ");
                    int i = Integer.parseInt(scanner.nextLine());
                    System.out.printf("sin(%.2f) = %.2f\n", x, x, bai4(x, i));
                    break;
                case 5:
                    System.out.print("Nhập m= ");
                    int m = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Dãy %d so fibonacii: %s\n", m, bai5(m));
            }
        } while (opt != 0);
    }
}
