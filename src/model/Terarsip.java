/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public interface Terarsip {
    String nomorRak();

    int lokasiLantai();

    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", Lantai " + lokasiLantai();
    }
}
