package quanlicuahang;

import java.util.Date;

public class Bia extends HangHoa {
    private LoaiBia loai;
    private Date ngayHetHan;
    private boolean isDaBan;

    public Bia(String ma, String ten, Date ngaySanXuat, Date ngayHetHan, float dungTich, double donGiaNhap, double donGiaBan, LoaiBia loai, boolean isDaBan) throws CHException {
        super(ma, ten, ngaySanXuat, dungTich, donGiaNhap, donGiaBan);
        this.loai = loai;
        setNgayHetHan(ngayHetHan);
        this.isDaBan = isDaBan;

        // Đặt thuế nhập khẩu cho bia ngoại
        if (loai == LoaiBia.HEINEKEN || loai == LoaiBia.TIGER || loai == LoaiBia.BUDWEISER || loai == LoaiBia.BECKS) {
            this.thueNhapKhau = MUC_THUE_NK_MAC_DINH;
        } else {
            this.thueNhapKhau = 0;
        }
    }

    public void setLoai(LoaiBia loai) {
        this.loai = loai;
    }

    public void setNgayHetHan(Date ngayHetHan) throws CHException {
        if (ngayHetHan == null) {
            throw new CHException("Ngày hết hạn không được để trống.");
        }
        this.ngayHetHan = ngayHetHan;
    }

    public void setDaBan(boolean isDaBan) {
        this.isDaBan = isDaBan;
    }

    @Override
    public String getLoai() {
        return loai.name();
    }

    @Override
    public DonViTinh getDonViTinh() {
        return DonViTinh.THUNG;
    }
}
