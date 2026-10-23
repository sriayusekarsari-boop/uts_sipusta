/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

/**
 *
 * @author DELL
 */
import model.koleksi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EksporKatalog {
    private static final String FORMAT = "%-6s %-14s %-32s %-6s %-12s %-10s%n";

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(namaBerkas)))) {
            out.printf(FORMAT, "KODE", "JENIS", "JUDUL", "TAHUN", "KELAYAKAN", "STATUS");
            out.println("-".repeat(86));
            for (koleksi k : katalog.getDaftar()) {
                out.printf(FORMAT, k.getKode(), k.jenis(), k.getJudul(), k.getTahunTerbit(),
                        k.layakDipinjam() ? "Layak" : "Tidak layak",
                        k.isSedangDipinjam() ? "Dipinjam" : "Tersedia");
            }
        }
    }
}