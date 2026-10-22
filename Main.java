package BT.BVN_Chuong4;

class SanPham {
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuongTon;

    public SanPham(){

    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham(String maSP, String tenSP, double donGia, int soLuongTon) {
        this(maSP, tenSP);
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    public String getTenSP() {
        return tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public void hienThi() {
        System.out.printf("%-6s %-20s %,.0f\t tồn %d \n", maSP, tenSP, donGia, soLuongTon);
    }
}

class DonHang {
    private String tenKhach;
    private SanPham sanPham;
    private int soLuong;

    public DonHang(String tenKhach, SanPham sanPham, int soLuong) {
        this.tenKhach = tenKhach;
        this.sanPham = sanPham;
        if (soLuong < 1) {
            this.soLuong = 1;
        } else {
            this.soLuong = soLuong;
        }
    }

    public double tinhThanhTien() {
        double thanhTien = sanPham.getDonGia() * soLuong;
        if (this.soLuong >= 5) {
            thanhTien = thanhTien * 0.9;
        }
        return thanhTien;
    }

    public void inDonHang(){
        System.out.printf("%-6s %-20s %-7d %,.0f%n" , tenKhach, sanPham.getTenSP(), soLuong, tinhThanhTien());
        if (this.soLuong >= 5) {
            System.out.printf("       (đã giảm 10%%)\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SanPham banPhim = new SanPham("SP01", "Bàn phím cơ", 450000, 20);
        SanPham chuot = new SanPham("SP02", "Chuột không dây", 200000, 50);
        SanPham taiNghe = new SanPham("SP03", "Tai nghe");
        taiNghe.setDonGia(350000);
        taiNghe.setSoLuongTon(10);

        System.out.println("==== DANH SÁCH SẢN PHẨM ====");
        banPhim.hienThi();
        chuot.hienThi();
        taiNghe.hienThi();
        System.out.println();

        DonHang don1 = new DonHang("An", banPhim, 2);
        DonHang don2 = new DonHang("Bình", chuot, 5);
        DonHang don3 = new DonHang("Chi", taiNghe, 1);

        System.out.println("==== DANH SÁCH ĐƠN HÀNG ====");
        System.out.printf("%-6s %-20s %-7s %s \n", "Khách", "Sản phẩm", "SL", "Thành tiền");
        don1.inDonHang();
        don2.inDonHang();
        don3.inDonHang();
    }
}
