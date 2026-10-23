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

import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<koleksi> {
    private final Comparator<koleksi> berlapis =
            Comparator.comparing((koleksi k) -> !k.layakDipinjam())   // false (layak) lebih dulu
                      .thenComparing(koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(koleksi a, koleksi b) {
        return berlapis.compare(a, b);
    }
}