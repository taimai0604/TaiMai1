package mac01.democucthue.model;

/**
 * Created by mac01 on 6/5/17.
 */

public class DataModel {
    private String soKiHieu;
    private String noiDung;

    public DataModel(String soKiHieu, String noiDung) {
        this.soKiHieu = soKiHieu;
        this.noiDung = noiDung;
    }

    public String getSoKiHieu() {
        return soKiHieu;
    }

    public void setSoKiHieu(String soKiHieu) {
        this.soKiHieu = soKiHieu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
