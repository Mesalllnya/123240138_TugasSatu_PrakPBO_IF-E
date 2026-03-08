package tugas1;
import java.util.Scanner;

public class Tugas1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        boolean loop = true; int jumlahTiket=0;
        Tiket[] daftarTiket = new Tiket[100];
        
        System.out.println("==TERMINAL LOKET OOP TIX==\n");
        
        while(loop && jumlahTiket < 100){
                System.out.print("-- Input Tiket ke-"+(jumlahTiket+1)+" --\n");
            try {
                System.out.print("Kode Booking (Diawali 'TIX'): ");String kodeT=input.next();
                System.out.print("Tanggal (DD/MM/YYYY)        : ");String tanggal=input.next();
                System.out.print("Waktu Keberangkatan         : ");String waktuBerangkat=input.next();
                System.out.print("Stasiun Tujuan              : ");String stTujuan=input.next();
                System.out.print("Harga Dasar                 : ");double hargaDasar=input.nextDouble();
                System.out.print("Kelas (eko=1,eks=2,lux=3)   : ");int tipe=input.nextInt();    
                
                Jadwal jadwal = new Jadwal(tanggal, stTujuan, waktuBerangkat);
                Tiket tempT = null;
                
                switch(tipe){
                    case 1:
                        tempT = new ekonomi(kodeT,jadwal, hargaDasar);
                        break;
                    case 2:
                        tempT = new eksekutif(kodeT,jadwal, hargaDasar);
                        break;
                    case 3:
                        tempT = new luxury(kodeT,jadwal, hargaDasar);
                        break;
                }
                
                daftarTiket[jumlahTiket] = tempT;
                jumlahTiket++;
                System.out.println("[SUKSES] Tiket berhasil dibuat");
                
            }catch (DataInvalidException e) {
                System.out.println(e);
            }catch (NumberFormatException e){
                System.out.println("[ERROR] Input harga/kelas harus berupa angka!");
            }
            
            // Meminta konfirmasi untuk lanjut
            System.out.print("Cetak tiket lain? (y/n): ");
            String konfirmasi = input.next();
            
            if (konfirmasi.equalsIgnoreCase("n")) {
                loop = false;
            }
            System.out.println("-------------------------");
            }
        
        // Cetak Rekapitulasi (Aturan 6.4)
        System.out.println("\nREKAPITULASI TIKET");
        if (jumlahTiket == 0) {
            System.out.println("Belum ada tiket yang diterbitkan.");
        } else {
            for (int i = 0; i < jumlahTiket; i++) {
                Tiket t = daftarTiket[i];
                System.out.println("Kode Booking: " + t.getKode());
                System.out.println("Jadwal      : " + t.getJadwal().getJadwal());
                System.out.println("Total Harga : Rp " + t.hitungHarga());

                // Mengecek apakah tiket ngambil LayananEksklusif (Polymorphism) 
                if (t instanceof layananEksklusif) {
                    layananEksklusif temp = (layananEksklusif) t;
                    System.out.println("Fasilitas   : " + temp.getFasilitasT());
                }
                System.out.println();
            }
        }
        System.out.println("Sesi loket diakhiri.");
        input.close();
        }
        
    }

    

