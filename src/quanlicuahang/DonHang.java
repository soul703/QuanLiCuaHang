package quanlicuahang;

import java.util.Date;
import java.util.List;

public class DonHang {
    private List<ChiTietDonHang> chiTietDonHangs;
    private KhachHang khachHang;
    private String maDonHang;
    private Date ngayBan;

    public DonHang(List<ChiTietDonHang> chiTietDonHangs, KhachHang khachHang, String maDonHang, Date ngayBan) throws CHException {
        if (chiTietDonHangs == null || chiTietDonHangs.isEmpty()) {
            throw new CHException("Danh sách chi tiết đơn hàng không được để trống.");
        }
        this.chiTietDonHangs = chiTietDonHangs;
        this.khachHang = khachHang;
        setMaDonHang(maDonHang);
        setNgayBan(ngayBan);
    }

    public final void setMaDonHang(String maDonHang) throws CHException {
        if (maDonHang == null || maDonHang.isBlank()) {
            throw new CHException("Mã đơn hàng không được để trống.");
        }
        this.maDonHang = maDonHang;
    }

    public final void setNgayBan(Date ngayBan) throws CHException {
        if (ngayBan == null) {
            throw new CHException("Ngày bán không được để trống.");
        }
        this.ngayBan = ngayBan;
    }

    public double tinhTongTien() {
        double tongTien = 0;
        for (ChiTietDonHang ctdh : chiTietDonHangs) {
            tongTien += ctdh.tinhThanhTien();
        }
        if (khachHang.getLoai() == LoaiKhachHang.VIP) {
            tongTien *= 0.95; // Giảm giá 5% cho khách hàng VIP
        }
        return tongTien;
    }

    public List<ChiTietDonHang> getChiTietDonHangs() {
        return chiTietDonHangs;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public Date getNgayBan() {
        return ngayBan;
    }
}
