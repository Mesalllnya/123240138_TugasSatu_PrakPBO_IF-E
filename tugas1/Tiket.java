package tugas1;


public abstract class Tiket {
    private String kodeTiket; 
    private double hargaDasar;
    private Jadwal jadwal;
    
    //validasi dan setter
    public Tiket(String kodeT, Jadwal jadwal, double hargaAwal) throws DataInvalidException{
        if(!kodeT.startsWith("TIX")){
            throw new DataInvalidException("[DITOLAK] kode Tiket harus diawali dengan 'TIX'");
        }
        if(hargaAwal <= 0 ){
            throw new DataInvalidException("[DITOLAK] Harga harus lebih dari 0");
        }
        
        this.kodeTiket=kodeT;
        this.hargaDasar=hargaAwal;
        this.jadwal=jadwal;
    }
    
    //getter
    public String getKode(){return this.kodeTiket;}
    public Jadwal getJadwal(){return this.jadwal;}
    public double getHarga(){return this.hargaDasar;}
    
    public abstract double hitungHarga();
}

interface layananEksklusif{
    String getFasilitasT(); 
}

class ekonomi extends Tiket{
    
    public ekonomi(String kodeT, Jadwal jadwal, double hargaAwal) throws DataInvalidException {
        super(kodeT, jadwal, hargaAwal);
    }

    @Override
    public double hitungHarga() {
        return getHarga();
    }    
}

class eksekutif extends Tiket implements layananEksklusif{
    
    public eksekutif(String kodeT, Jadwal jadwal, double hargaAwal) throws DataInvalidException {
        super(kodeT, jadwal, hargaAwal);
    }

    @Override
    public double hitungHarga() {
        return getHarga() + 5000;
    }
    
    @Override
    public String getFasilitasT(){
        return "Makan siang";
    } 
    
}

class luxury extends Tiket implements layananEksklusif{
    
    public luxury(String kodeT, Jadwal jadwal, double hargaAwal) throws DataInvalidException {
        super(kodeT, jadwal, hargaAwal);
    }

    @Override
    public double hitungHarga() {
        return getHarga() + 150000;
    }
    
    @Override
    public String getFasilitasT(){
        return "Makan siang dan Kursi Sleeper";
    } 
    
}