package quanlicuahang;

import java.util.Date;

public abstract class HangHoa implements ThueNhapKhau {
    protected String ma;
    protected String ten;
    protected Date ngaySanXuat;
    protected float dungTich;
    protected double donGiaNhap;
    protected double donGiaBan;

    // Thuế nhập khẩu có thể được định nghĩa trong các lớp con nếu cần
    protected double thueNhapKhau = MUC_THUE_NK_MAC_DINH;

    public HangHoa(String ma, String ten, Date ngaySanXuat, float dungTich, double donGiaNhap, double donGiaBan) throws CHException {
        setMa(ma);
        setTen(ten);
        setNgaySanXuat(ngaySanXuat);
        setDungTich(dungTich);
        setDonGiaNhap(donGiaNhap);
        setDonGiaBan(donGiaBan);
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public float getDungTich() {
        return dungTich;
    }

    public double getDonGiaNhap() {
        return donGiaNhap;
    }
    

    public void setMa(String ma) throws CHException {
        if (ma == null || ma.isBlank()) {
            throw new CHException("Mã hàng hóa không được để trống.");
        }
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaySanXuat(Date ngaySanXuat) throws CHException {
        if (ngaySanXuat == null) {
            throw new CHException("Ngày sản xuất không được để trống.");
        }
        this.ngaySanXuat = ngaySanXuat;
    }

    public void setDungTich(float dungTich) throws CHException {
        if (dungTich <= 0) {
            throw new CHException("Dung tích phải lớn hơn 0.");
        }
        this.dungTich = dungTich;
    }

    public void setDonGiaNhap(double donGiaNhap) throws CHException {
        if (donGiaNhap < 0) {
            throw new CHException("Đơn giá nhập không được âm.");
        }
        this.donGiaNhap = donGiaNhap;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) throws CHException {
        if (donGiaBan < 0) {
            throw new CHException("Đơn giá bán không được âm.");
        }
        this.donGiaBan = donGiaBan;
    }

    @Override
    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public abstract String getLoai();
    public abstract DonViTinh getDonViTinh();
}
