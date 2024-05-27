package com.tubespbo.model;

import java.util.*;
import java.time.LocalDate;

public class BarangKeluar extends Barang {
    private LocalDate tglBarangKeluar;
    private List<Barang> daftarBarangKeluar = new ArrayList<>();

    public BarangKeluar(String kodeBarang, String namaBarang, String satuanBarang, int jumlahBarang, LocalDate tglBarangKeluar){
        super(namaBarang, kodeBarang, satuanBarang, jumlahBarang);
        this.tglBarangKeluar = tglBarangKeluar;
    }

    public LocalDate getTglBarangKeluar() {
        return tglBarangKeluar;
    }

    public void setTglBarangKeluar(LocalDate tglBarangKeluar) {
        this.tglBarangKeluar = tglBarangKeluar;
    }

    public void tambahBarangKeluar(Barang barang, Date tglBarangKeluar) {
        daftarBarangKeluar.add(barang);
    }

    @Override
    public String toString() {
        return "Barang keluar berhasil ditambahkan";
    }
}