package quanlicuahang;

import java.util.Date;

public class Ruou extends HangHoa {
    private LoaiRuou loai;

    public Ruou(String ma, String ten, Date ngaySanXuat, float dungTich, double donGiaNhap, double donGiaBan, LoaiRuou loai) throws CHException {
        super(ma, ten, ngaySanXuat, dungTich, donGiaNhap, donGiaBan);
        this.loai = loai;

        // Đặt thuế nhập khẩu cho rượu ngoại
        if (loai == LoaiRuou.CHIVAS_REGAL || loai == LoaiRuou.JOHNNIE_WALKER ||
            loai == LoaiRuou.HENNESSY || loai == LoaiRuou.MACALLAN) {
            this.thueNhapKhau = MUC_THUE_NK_MAC_DINH;
        } else {
            this.thueNhapKhau = 0;
        }
    }

    public void setLoai(LoaiRuou loai) {
        this.loai = loai;
    }

    @Override
    public String getLoai() {
        return loai.name();
    }

    @Override
    public DonViTinh getDonViTinh() {
        return DonViTinh.CHAI;
    }
}
