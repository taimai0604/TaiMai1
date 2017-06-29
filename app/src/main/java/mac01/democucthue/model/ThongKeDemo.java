package mac01.democucthue.model;

/**
 * Created by mac01 on 6/24/17.
 */

public class ThongKeDemo {
    private int stt;
    private String ten;
    private int cxlTrongHan;
    private int cxlQuaHan;
    private int dxlTrongHan;
    private int dxlQuaHan;

    public ThongKeDemo(int stt, String ten, int cxlTrongHan, int cxlQuaHan, int dxlTrongHan, int dxlQuaHan) {
        this.stt = stt;
        this.ten = ten;
        this.cxlTrongHan = cxlTrongHan;
        this.cxlQuaHan = cxlQuaHan;
        this.dxlTrongHan = dxlTrongHan;
        this.dxlQuaHan = dxlQuaHan;
    }

    public int getstt() {
        return stt;
    }

    public void setstt(int stt) {
        this.stt = stt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getCxlTrongHan() {
        return cxlTrongHan;
    }

    public void setCxlTrongHan(int cxlTrongHan) {
        this.cxlTrongHan = cxlTrongHan;
    }

    public int getCxlQuaHan() {
        return cxlQuaHan;
    }

    public void setCxlQuaHan(int cxlQuaHan) {
        this.cxlQuaHan = cxlQuaHan;
    }

    public int getDxlTrongHan() {
        return dxlTrongHan;
    }

    public void setDxlTrongHan(int dxlTrongHan) {
        this.dxlTrongHan = dxlTrongHan;
    }

    public int getDxlQuaHan() {
        return dxlQuaHan;
    }

    public void setDxlQuaHan(int dxlQuaHan) {
        this.dxlQuaHan = dxlQuaHan;
    }
}
