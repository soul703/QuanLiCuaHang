package quanlicuahang;

public class KhachHang {
    private String soDienThoai;
    private String hoTen;
    private String diaChi;
    private LoaiKhachHang loai;

    public KhachHang(String soDienThoai, String hoTen, String diaChi, LoaiKhachHang loai) throws CHException {
        if (soDienThoai == null || soDienThoai.isBlank()) {
            throw new CHException("Số điện thoại không được để trống.");
        }
        this.soDienThoai = soDienThoai;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loai = loai;
    }

    public void setSoDienThoai(String soDienThoai) throws CHException {
        if (soDienThoai == null || soDienThoai.isBlank()) {
            throw new CHException("Số điện thoại không được để trống.");
        }
        this.soDienThoai = soDienThoai;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setLoai(LoaiKhachHang loai) {
        this.loai = loai;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public LoaiKhachHang getLoai() {
        return loai;
    }
}
