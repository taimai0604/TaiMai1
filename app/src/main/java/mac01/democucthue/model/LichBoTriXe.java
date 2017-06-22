package mac01.democucthue.model;

/**
 * Created by mac01 on 5/31/17.
 */

public class LichBoTriXe {
    String thoiGian;
    String nguoiChuTri;
    String noiDung;
    String phanCongChuanBi;
    String thanhPhan;
    String loaiXe;
    String diaDiem;
    String tinhTrang;

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNguoiChuTri() {
        return nguoiChuTri;
    }

    public void setNguoiChuTri(String nguoiChuTri) {
        this.nguoiChuTri = nguoiChuTri;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getPhanCongChuanBi() {
        return phanCongChuanBi;
    }

    public void setPhanCongChuanBi(String phanCongChuanBi) {
        this.phanCongChuanBi = phanCongChuanBi;
    }

    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public LichBoTriXe(String thoiGian, String nguoiChuTri, String noiDung, String phanCongChuanBi, String thanhPhan, String loaiXe, String diaDiem, String tinhTrang) {
        this.thoiGian = thoiGian;
        this.nguoiChuTri = nguoiChuTri;
        this.noiDung = noiDung;
        this.phanCongChuanBi = phanCongChuanBi;
        this.thanhPhan = thanhPhan;
        this.loaiXe = loaiXe;
        this.diaDiem = diaDiem;
        this.tinhTrang = tinhTrang;
    }
}
