package bai2;

import java.util.Scanner;

public class Main {
    public static String bai1(int number) {
        switch (number) {
            case 0: return "Số không";
            case 1: return "Số một";
            case 2: return "Số hai";
            case 3: return "Số ba";
            case 4: return "Số bốn";
            case 5: return "Số năm";
            case 6: return "Số sáu";
            case 7: return "Số bảy";
            case 8: return "Số tám";
            case 9: return "Số chín";
            default: return "Không đọc được";
        }
    }

    public static double bai2(double x) {
        if (x >= 3) {
            return (x + 3) * (x + 3);
        } else if (x > 2) {
            return 5 * Math.cos(3 * x + 2) - Math.log(x * x + 2);
        } else {
            return 1;
        }
    }

    public static long bai3(float m) {
        long money = (long) (14000 * m);
        float buyMore = m - 50;
        if (buyMore >= 0.1 && buyMore <= 25) {
            return (long) (money + buyMore * 13500);
        } else if (buyMore >= 26 && buyMore <= 40) {
            return (long) (money + buyMore * 13250);
        } else if (buyMore >= 41 && buyMore <= 55) {
            return (long) (money + buyMore * 13000);
        } else if (buyMore > 55) {
            return (long) (money + buyMore * 12500);
        } else {
            return money;
        }
    }

    public static void bai4() {
        System.out.println("Nhập tọa độ điểm A:");
        ToaDo A = new ToaDo().inputData(new Scanner(System.in));
        System.out.println("Nhập tọa độ điểm B:");
        ToaDo B = new ToaDo().inputData(new Scanner(System.in));
        System.out.println("Nhập tọa độ điểm C:");
        ToaDo C = new ToaDo().inputData(new Scanner(System.in));
        System.out.printf("AB= %.2f\n", A.distance(B));
        System.out.printf("BC= %.2f\n", B.distance(C));
        System.out.printf("CA= %.2f\n", C.distance(A));
        if (A.distance(B) + B.distance(C) == C.distance(A) || B.distance(C) + C.distance(A) == A.distance(C) ||
        C.distance(A) + A.distance(B) == B.distance(C)) {
            System.out.println("Ba điểm A, B, C thẳng hàng");
        } else {
            double p = A.distance(B) + B.distance(C) + C.distance(A);
            double s = Math.sqrt(p * (p - A.distance(B)) * (p - B.distance(A)) * (p - C.distance(A)));
            System.out.printf("Chu vi tam giác ABC là %.2f\n", 2 * p);
            System.out.printf("Diện tích tam giác ABC là %.2f\n", s);
            System.out.printf("Bán kính đường trọn ngoại tiếp tam giác ABC là %.2f\n",
                    A.distance(B) * B.distance(C) * C.distance(A) / (4 * s));
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
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Nhập số cần đọc ");
                    int number = Integer.parseInt(scanner.nextLine());
                    System.out.println(bai1(number));
                    break;
                case 2:
                    System.out.print("Nhập x= ");
                    double x = Double.parseDouble(scanner.nextLine());
                    System.out.printf("y= %.2f\n", bai2(x));
                    break;
                case 3:
                    System.out.print("Nhập số kg gạo muốn mua: ");
                    float m = Float.parseFloat(scanner.nextLine());
                    System.out.printf("Số tiền phải trả là: %,d\n", bai3(m));
                    break;
                case 4:
                    bai4();
                    break;
            }
        } while (opt != 5);
    }
}
