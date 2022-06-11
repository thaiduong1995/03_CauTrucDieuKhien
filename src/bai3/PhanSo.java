package bai3;

import java.util.Scanner;

public class PhanSo {
    private long tuSo;
    private long mauSo;

    public long getTuSo() {
        return tuSo;
    }

    public void setTuSo(long tuSo) {
        this.tuSo = tuSo;
    }

    public long getMauSo() {
        return mauSo;
    }

    public void setMauSo(long mauSo) {
        this.mauSo = mauSo;
    }

    public PhanSo inputData(Scanner scanner) {
        System.out.print("Nhập giá trị tử số: ");
        this.tuSo = Long.parseLong(scanner.nextLine());
        System.out.print("Nhập giá trị mẫu số: ");
        this.mauSo = Long.parseLong(scanner.nextLine());
        return this;
    }

    @Override
    public String toString() {
        return String.format("%d / %d", this.tuSo, this.mauSo);
    }

    public PhanSo toiGianPS() {
        long ucln = 1;
        long min = Math.min(this.tuSo, this.mauSo);
        for (long i = min; i > 1; i--) {
            if (this.tuSo % i == 0 && this.mauSo % i == 0) {
                ucln = i;
                break;
            }
        }
        this.tuSo /= ucln;
        this.mauSo /= ucln;
        return this;
    }
}
