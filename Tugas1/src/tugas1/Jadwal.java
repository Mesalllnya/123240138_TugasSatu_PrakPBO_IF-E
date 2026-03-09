package tugas1;

public class Jadwal {

    //ENCAPSULATION = menjaga keamanan / membungkus data
    private String tanggal;
    private String tujuan;
    private String waktu;
    
    //setter
    public Jadwal(String tgl, String tujuan, String waktu){
        this.tanggal=tgl;
        this.tujuan=tujuan;
        this.waktu=waktu;
    }
    
    //getter
    public String getJadwal(){
        return this.tanggal+" "+this.waktu+"  - Tujuan: "+this.tujuan;
    }
}
