package bai2;

import java.util.Scanner;

public class ToaDo {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ToaDo inputData(Scanner scanner) {
        System.out.print("Nhập giá trị hoành độ: ");
        this.x = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập giá trị tung độ: ");
        this.y = Double.parseDouble(scanner.nextLine());
        return this;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }

    public double distance(ToaDo M) {
        return Math.sqrt((this.x - M.getX()) * (this.x - M.getX()) + (this.y - M.getY()) * (this.y - M.getY()));
    }
}
