package quanlicuahang;

import java.util.*;

public class CuaHang {
    private List<DonHang> donHangs = new ArrayList<>();
    private List<KhachHang> khachHangs = new ArrayList<>();
    private List<HangHoa> hangHoas = new ArrayList<>();

    public void addDonHang(DonHang donHang) {
        donHangs.add(donHang);
    }

    public void addKhachHang(KhachHang khachHang) {
        khachHangs.add(khachHang);
    }

    public void addHangHoa(HangHoa hangHoa) {
        hangHoas.add(hangHoa);
    }

    public KhachHang timKhachHangMuaRuouNhieuNhat() {
        Map<KhachHang, Integer> soLuongMuaRuou = new HashMap<>();
        for (DonHang donHang : donHangs) {
            for (ChiTietDonHang chiTiet : donHang.getChiTietDonHangs()) {
                if (chiTiet.getHangHoa() instanceof Ruou) {
                    KhachHang khachHang = donHang.getKhachHang();
                    soLuongMuaRuou.put(khachHang, soLuongMuaRuou.getOrDefault(khachHang, 0) + chiTiet.getSoLuong());
                }
            }
        }
        return Collections.max(soLuongMuaRuou.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public KhachHang timKhachHangMuaBiaNhieuNhat() {
        Map<KhachHang, Integer> soLuongMuaBia = new HashMap<>();
        for (DonHang donHang : donHangs) {
            for (ChiTietDonHang chiTiet : donHang.getChiTietDonHangs()) {
                if (chiTiet.getHangHoa() instanceof Bia) {
                    KhachHang khachHang = donHang.getKhachHang();
                    soLuongMuaBia.put(khachHang, soLuongMuaBia.getOrDefault(khachHang, 0) + chiTiet.getSoLuong());
                }
            }
        }
        return Collections.max(soLuongMuaBia.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public HangHoa timLoaiRuouDuocMuaNhieuNhat() {
        Map<HangHoa, Integer> soLuongMuaRuou = new HashMap<>();
        for (DonHang donHang : donHangs) {
            for (ChiTietDonHang chiTiet : donHang.getChiTietDonHangs()) {
                if (chiTiet.getHangHoa() instanceof Ruou) {
                    HangHoa hangHoa = chiTiet.getHangHoa();
                    soLuongMuaRuou.put(hangHoa, soLuongMuaRuou.getOrDefault(hangHoa, 0) + chiTiet.getSoLuong());
                }
            }
        }
        return Collections.max(soLuongMuaRuou.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public HangHoa timLoaiBiaDuocMuaNhieuNhat() {
        Map<HangHoa, Integer> soLuongMuaBia = new HashMap<>();
        for (DonHang donHang : donHangs) {
            for (ChiTietDonHang chiTiet : donHang.getChiTietDonHangs()) {
                if (chiTiet.getHangHoa() instanceof Bia) {
                    HangHoa hangHoa = chiTiet.getHangHoa();
                    soLuongMuaBia.put(hangHoa, soLuongMuaBia.getOrDefault(hangHoa, 0) + chiTiet.getSoLuong());
                }
            }
        }
        return Collections.max(soLuongMuaBia.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
