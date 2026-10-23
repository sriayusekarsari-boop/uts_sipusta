/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

import model.koleksi;

/**
 *
 * @author DELL
 */

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.koleksi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private final List<koleksi> daftar = new ArrayList<>();

    public void tambah(koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<koleksi> getDaftar() {
        return List.copyOf(daftar);
    }

    /** Polimorfik: tiap objek menentukan sendiri deskripsi dan kelayakannya. */
    public void cetakStatus() {
        for (koleksi k : daftar) {
            String layak = k.layakDipinjam() ? "LAYAK" : "TIDAK LAYAK";
            String status = k.isSedangDipinjam() ? "DIPINJAM" : "TERSEDIA";
            System.out.println("[" + k.jenis() + "] " + k.deskripsi());
            System.out.println("    Kelayakan: " + layak + " | Status: " + status);
        }
    }

    /** Aturan pengurutan dapat diganti dari luar (Soal 4). */
    public void urut(Comparator<koleksi> pembanding) {
        daftar.sort(pembanding);
    }

    public void pinjam(String kode) throws PustakaException {
        koleksi k = cari(kode);
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(k.getJudul());
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul());
        }
        k.setSedangDipinjam(true);
    }

    public void kembalikan(String kode) throws PustakaException {
        cari(kode).setSedangDipinjam(false);
    }

    private koleksi cari(String kode) throws PustakaException {
        for (koleksi k : daftar) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        throw new PustakaException("Koleksi dengan kode " + kode + " tidak ditemukan di katalog.");
    }
}