package quanlicuahang;

public class ChiTietDonHang {
    private HangHoa hangHoa;
    private int soLuong;

    public ChiTietDonHang(HangHoa hangHoa, int soLuong) throws CHException {
        if (soLuong <= 0) {
            throw new CHException("Số lượng phải lớn hơn 0.");
        }
        this.hangHoa = hangHoa;
        this.soLuong = soLuong;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }
    
    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }
    public Integer getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) throws CHException {
        if (soLuong <= 0) {
            throw new CHException("Số lượng phải lớn hơn 0.");
        }
        this.soLuong = soLuong;
    }

    public double tinhThanhTien() {
        double giaBan = hangHoa.getDonGiaBan();
        double thueNhapKhau = hangHoa.getThueNhapKhau(); // Lấy thuế nhập khẩu từ interface

        // Tính tổng tiền với thuế nhập khẩu và thuế GTGT 10%
        return soLuong * (giaBan + giaBan * thueNhapKhau + giaBan * 0.1);
    }
}
