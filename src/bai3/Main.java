package bai3;

import java.util.Scanner;

public class Main {
    public static long bai1(int n) {
        long output;
        if (n < 0) {
            output = -1;
        } else if (n < 2) {
            output = 1;
        } else {
            output = 1;
            for (int i = 2; i <= n; i++) {
                output *= i;
            }
        }
        return output;
    }

    public static long bai2(long n) {
        String str = Long.toString(n);
        StringBuilder stringBuilder = new StringBuilder();
        return Long.parseLong(stringBuilder.append(str).reverse().toString());
    }

    public static double bai3(double x, int i) {
        double result = 0;
        if (i < 0) {
            result = -1;
        } else {
            for (int j = 0; j < i; j++) {
                result += Math.pow(x, j) / bai1(j);
            }
        }
        return result;
    }

    public static PhanSo bai4(PhanSo ps) {
        return ps.toiGianPS();
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
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Nhập n= ");
                    int number = Integer.parseInt(scanner.nextLine());
                    System.out.println(bai1(number));
                    break;
                case 2:
                    System.out.print("Nhập n= ");
                    long n = Long.parseLong(scanner.nextLine());
                    System.out.printf("y= %d\n", bai2(n));
                    break;
                case 3:
                    System.out.print("Nhập x= ");
                    double x = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập sai số epsilon i= ");
                    int i = Integer.parseInt(scanner.nextLine());
                    System.out.printf("e%.2f = %.2f\n", x, bai3(x, i));
                    break;
                case 4:
                    PhanSo ps = new PhanSo();
                    ps.inputData(scanner);
                    bai4(ps);
                    System.out.println(ps);
                    break;
            }
        } while (opt != 0);
    }
}
