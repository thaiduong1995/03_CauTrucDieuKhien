package bai1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void giaiPTBacHai(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình có vô số nghiệm");
                } else {
                    System.out.println("Phương trình vô nghiệm");
                }
            } else {
                System.out.printf("Phương trình có 1 ngiệm duy nhất là %.2\n", (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Phương trình không có nghiệm thực");
            } else if (delta == 0) {
                System.out.printf("Phương trình có nghiệm kép là x1= x2= %.2f\n", (-b / (2 * a)));
            } else {
                System.out.printf("Phương trình có hai nghiệm phân biệt lần lượt là x1= %.2f, x2= %.2f\n",
                        ((-b + Math.sqrt(delta)) / (2 * a)), ((-b - Math.sqrt(delta)) / (2 * a)));
            }
        }
    }

    public static String xepLoai(float diem) {
        String ranked = "Xếp loại: ";
        if (diem > 8) {
            ranked += "Giỏi";
        } else if (diem > 7) {
            ranked += "Khá";
        } else if (diem > 5) {
            ranked += "Trung bình";
        } else {
            ranked += "Yếu";
        }
        return ranked;
    }

    public static long tienLuong(long lc, long ds) {
        if (ds > 150000000) {
            return (long) (lc + ds * 1.1);
        } else if (ds > 100000000) {
            return (long) (lc + ds * 1.05);
        } else if (ds > 50000000) {
            return lc;
        } else {
            return (long) (lc * 0.9);
        }
    }

    /**
     * tham số truyền vào có đinh dạng ngày/tháng/năm
     */
    public static String soNgayTrongThang(String date) throws ParseException {
        int[] month31 = {1, 3, 5, 7, 8, 10, 12};
        int[] month30 = {4, 6, 9, 11};
        LocalDate localDate =
                new SimpleDateFormat("dd/MM/yyyy").parse(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (IntStream.of(month31).anyMatch(x->x == localDate.getMonthValue())) {
            return localDate.getMonthValue() + " có 31 ngày";
        } else if (IntStream.of(month30).anyMatch(x->x == localDate.getMonthValue())) {
            return localDate.getMonthValue() + " có 30 ngày";
        } else if (localDate.getYear() % 4 == 0) {
            return localDate.getMonthValue() + " có 29 ngày";
        } else {
            return localDate.getMonthValue() + " có 28 ngày";
        }
    }

    public static void main(String[] args) throws ParseException {
        int opt;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chương trình:");
            System.out.println("1. Giải phương trình bậc 2: ax2 + bx + c = 0");
            System.out.println("2. Xếp loại học tập");
            System.out.println("3. Tính tiền lương");
            System.out.println("4. Tính số ngày trong tháng");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("Nhập a= ");
                    int a = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập b= ");
                    int b = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nhập c= ");
                    int c = Integer.parseInt(scanner.nextLine());
                    giaiPTBacHai(a, b, c);
                    break;
                case 2:
                    System.out.print("Nhập điểm: ");
                    float point = Float.parseFloat(scanner.nextLine());
                    System.out.println(xepLoai(point));
                    break;
                case 3:
                    System.out.print("Nhập lương cứng: ");
                    long lc = Long.parseLong(scanner.nextLine());
                    System.out.print("Nhập doanh số: ");
                    long ds = Long.parseLong(scanner.nextLine());
                    System.out.printf("Tiền lương thực lĩnh: %,d\n", tienLuong(lc, ds));
                    break;
                case 4:
                    System.out.print("Nhập thời gian( ngày/tháng/năm): ");
                    String date = scanner.nextLine();
                    System.out.println(soNgayTrongThang(date));
                    break;
            }
        } while (opt != 5);
    }
}
