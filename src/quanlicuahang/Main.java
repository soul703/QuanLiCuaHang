package quanlicuahang;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Tạo các đối tượng hàng hóa
            Ruou ruouNgoai1 = new Ruou("R1", "Chivas Regal", new Date(121, 5, 15), 0.75f, 1500, 2000, LoaiRuou.CHIVAS_REGAL);
            Ruou ruouNoi1 = new Ruou("R2", "Rượu nếp", new Date(122, 2, 10), 0.5f, 800, 1200, LoaiRuou.NEP);
            Bia biaNgoai1 = new Bia("B1", "Heineken", new Date(123, 3, 25), new Date(125, 3, 25), 0.5f, 2000, 2500, LoaiBia.HEINEKEN, false);
            Bia biaNoi1 = new Bia("B2", "Bia Sài Gòn", new Date(124, 4, 30), new Date(126, 4, 30), 0.5f, 1500, 2000, LoaiBia.SAI_GON, false);

            // Tạo khách hàng
            KhachHang khachHang1 = new KhachHang("0123456789", "Nguyễn Văn A", "Hà Nội", LoaiKhachHang.VIP);
            KhachHang khachHang2 = new KhachHang("0987654321", "Trần Thị B", "TP.HCM", LoaiKhachHang.BINH_THUONG);

            // Tạo chi tiết đơn hàng
            ChiTietDonHang chiTiet1 = new ChiTietDonHang(ruouNgoai1, 3);
            ChiTietDonHang chiTiet2 = new ChiTietDonHang(biaNoi1, 2);
            ChiTietDonHang chiTiet3 = new ChiTietDonHang(ruouNoi1, 1);

            // Tạo đơn hàng
            List<ChiTietDonHang> chiTietDonHangList1 = Arrays.asList(chiTiet1, chiTiet2);
            List<ChiTietDonHang> chiTietDonHangList2 = Arrays.asList(chiTiet3);

            DonHang donHang1 = new DonHang(chiTietDonHangList1, khachHang1, "DH001", new Date());
            DonHang donHang2 = new DonHang(chiTietDonHangList2, khachHang2, "DH002", new Date());

            // Tạo cửa hàng và thêm các đối tượng
            CuaHang cuaHang = new CuaHang();
            cuaHang.addDonHang(donHang1);
            cuaHang.addDonHang(donHang2);
            cuaHang.addKhachHang(khachHang1);
            cuaHang.addKhachHang(khachHang2);
            cuaHang.addHangHoa(ruouNgoai1);
            cuaHang.addHangHoa(ruouNoi1);
            cuaHang.addHangHoa(biaNgoai1);
            cuaHang.addHangHoa(biaNoi1);

            // In tổng tiền cho đơn hàng
            System.out.println("Tổng tiền đơn hàng 1: " + donHang1.tinhTongTien());
            System.out.println("Tổng tiền đơn hàng 2: " + donHang2.tinhTongTien());

            // Tìm khách hàng mua nhiều rượu nhất
            KhachHang khachHangMuaRuouNhieuNhat = cuaHang.timKhachHangMuaRuouNhieuNhat();
            System.out.println("Khách hàng mua nhiều rượu nhất: " + khachHangMuaRuouNhieuNhat.getHoTen());

            // Tìm khách hàng mua nhiều bia nhất
            KhachHang khachHangMuaBiaNhieuNhat = cuaHang.timKhachHangMuaBiaNhieuNhat();
            System.out.println("Khách hàng mua nhiều bia nhất: " + khachHangMuaBiaNhieuNhat.getHoTen());

            // Tìm loại rượu được mua nhiều nhất
            HangHoa loaiRuouDuocMuaNhieuNhat = cuaHang.timLoaiRuouDuocMuaNhieuNhat();
            System.out.println("Loại rượu được mua nhiều nhất: " + loaiRuouDuocMuaNhieuNhat.getTen());

            // Tìm loại bia được mua nhiều nhất
            HangHoa loaiBiaDuocMuaNhieuNhat = cuaHang.timLoaiBiaDuocMuaNhieuNhat();
            System.out.println("Loại bia được mua nhiều nhất: " + loaiBiaDuocMuaNhieuNhat.getTen());

        } catch (CHException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

