import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;



class kendaraan{
    public String merk;
    public String warna;
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;
    
    public penumpang[] listPenumpang;
    public int indxP;

    public mas_supir supir;
    
    public kendaraan(String pn, String m, int max){
        this.merk = m;
        this.platNomor = pn;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = max;

        this.listPenumpang = new penumpang[max];
    
    }
    
    public void cekPenumpang(){
        System.out.println("Penumpang saat ini: "+ this.jumlahPenumpang + "/" + maxPenumpang);
    }
    
    public void penumpangNaik(int naik){
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang){
            System.out.println("maaf penumpang melebihi kapasitas");
        }
        else{
            this.jumlahPenumpang += naik;
            System.out.println("penumpang berhasil naik");
        }
        cekPenumpang();
    }

    public void penumpangNaik(String nama){
        int current = this.jumlahPenumpang;
        if (current > this.maxPenumpang) {
            System.out.println("maaf penumpang melebihi kapasitas");
        } else {
            System.out.println("input nama penumpang : " + nama);
            this.listPenumpang [this.jumlahPenumpang] = new penumpang(nama);
            this.jumlahPenumpang++;
        }
        cekPenumpang();

    }
    
    public void penumpangTurun(int turun){
        System.out.println("ada penumpang mau turun: "+ turun);
        int current = this.jumlahPenumpang;
        if (current - turun < 0){
            System.out.println("maaf penumpang yang ingin diturunkan melebihi jumlah penumpang saat ini");
        }
        else{
            this.jumlahPenumpang -= turun;
            System.out.println("penumpang berhasil turun");
        }
        cekPenumpang();
    }

    void tambah_supir(mas_supir Supir){
        this.supir = Supir;
    }

    mas_supir getSupir(){
        return supir;
    }
}

class penumpang {
    public String nama;

    public penumpang(String nama) {
        this.nama = nama;
    }
}


class mas_supir{
    private String nama;

    mas_supir(String nama) {
        this.nama = nama;
    }

    String getNama() {
        return nama;
    }
}

class bus extends kendaraan{
    String conToilet;
    public bus(String pn, String m, int max, String conToilet){
        super(pn, m, max);
        this.conToilet = conToilet;
    }
    void cekToilet(String conToilet){
        System.out.println("Maaf toilet nya saat ini sedang " +  conToilet);
    }
}

class truk extends kendaraan{
    int maxMuatan;
    public truk(String pn, String m, int max, int maxMuatan){
        super(pn, m, max);
        this.maxMuatan = maxMuatan;
        
    }
    void inputMuatan(int Muatan) {
        if (Muatan > maxMuatan) {
            System.out.println("Muatan sudah penuh ");
        } else {
            System.out.println("Muatan sebesar " + Muatan + " ton berhasil diangkut");
        }
    }
}

public class LK02 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int pilihan =0;
        
        truk t1 = new truk("N 1234 YY", "HINO", 3 , 5);
        mas_supir cupir = new mas_supir("tono");
        t1.tambah_supir(cupir);
        
        kendaraan mobil = new kendaraan("B 2209 K","Lamborghini",7);
        mas_supir cupir1 = new mas_supir("kuno");
        mobil.tambah_supir(cupir1);
        
        bus b1 = new bus("K 1209 YY","Mercy", 20,"full");
        mas_supir cupir2 = new mas_supir("joko");
        b1.tambah_supir(cupir2);
        
        System.out.println("1. Mobil");
        System.out.println("2. Truk");
        System.out.println("3. Bus");
        System.out.print("Pilih kendaraan yang ingin ditumpangi: ");
        String milihKendaraan = input.next();        
        
        if (milihKendaraan.equalsIgnoreCase("mobil")){
            while (pilihan != 4) {
                System.out.println("Menu:");
                System.out.println("1. Naik");
                System.out.println("2. Turun");
                System.out.println("3. Cek Penumpang");
                System.out.println("4. Keluar");
                
                System.out.print("Pilih menu (masukkan angka): ");
                pilihan = input.nextInt();
                
                switch (pilihan) {
                    case 1:
                    System.out.println("Berapa jumlah penumpang naik?");
                    System.out.print("(masukkan angka): ");
                    int naik = input.nextInt();
                    mobil.penumpangNaik(naik);
                    break;
                    case 2:
                    System.out.println("Berapa jumlah penumpang turun?");
                    System.out.print("(masukkan angka): ");
                    int turun = input.nextInt();
                    mobil.penumpangTurun(turun);
                    break;
                    case 3:
                    mobil.cekPenumpang();
                    break;
                    case 4:
                    System.out.println("Terima kasih. Program berhenti.");
                    break;
                    default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }
            }    
        }
        else if (milihKendaraan.equalsIgnoreCase("truk")) {
            while (pilihan != 6) {
                System.out.println("Menu:");
                System.out.println("1. Naik");
                System.out.println("2. Turun");
                System.out.println("3. Cek Penumpang");
                System.out.println("4. Nama driver");
                System.out.println("5. Muatan");
                System.out.println("6. Keluar");
                
                System.out.print("Pilih menu (masukkan angka): ");
                pilihan = input.nextInt();
                
                switch (pilihan) {
                    case 1:
                    System.out.println("Berapa jumlah penumpang naik?");
                    System.out.print("(masukkan angka): ");
                    int naik = input.nextInt();
                    t1.penumpangNaik(naik);
                    break;
                    case 2:
                    System.out.println("Berapa jumlah penumpang turun?");
                    System.out.print("(masukkan angka): ");
                    int turun = input.nextInt();
                    t1.penumpangTurun(turun);
                    break;
                    case 3:
                    t1.cekPenumpang();
                    break;
                    case 4:
                    System.out.println("Truk ini dikendarai oleh : " + t1.getSupir().getNama());
                    break;
                    case 5:
                    System.out.println("Masukkan jumlah muatan");
                    t1.inputMuatan( input.nextInt());
                    case 6:
                    System.out.println("Terima kasih. Program berhenti.");
                    break;
                    default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }
            }    
        }

        else if (milihKendaraan.equalsIgnoreCase("bus")) {
            while (pilihan != 6) {
                System.out.println("Menu:");
                System.out.println("1. Naik");
                System.out.println("2. Turun");
                System.out.println("3. Cek Penumpang");
                System.out.println("4. Nama driver");
                System.out.println("5. CekToilet");
                System.out.println("6. Keluar");
                
                System.out.print("Pilih menu (masukkan angka): ");
                pilihan = input.nextInt();
                
                switch (pilihan) {
                    case 1:
                    System.out.println("Nama penumpang yang naik : ");
                    String nama = input.next();
                    b1.penumpangNaik(nama);
                    break;
                    case 2:
                    System.out.println("Berapa jumlah penumpang turun?");
                    System.out.print("(masukkan angka): ");
                    int turun = input.nextInt();
                    b1.penumpangTurun(turun);
                    break;
                    case 3:
                    b1.cekPenumpang();
                    break;
                    case 4:
                    System.out.println("bus ini dikendarai oleh : " + b1.getSupir().getNama());
                    break;
                    case 5:
                    System.out.println("Kondisi toilet : ");
                    b1.cekToilet("penuh");
                    case 6:
                    System.out.println("Terima kasih. Program berhenti.");
                    break;
                    default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
                }
            }    
        }

        
        
        input.close();

    
    }
}