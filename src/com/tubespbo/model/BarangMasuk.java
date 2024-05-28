package com.tubespbo.model;

import java.time.LocalDate;
import java.util.*;

public class BarangMasuk extends Barang {
    private LocalDate tglBarangMasuk;
    private List<Barang> daftarBarangMasuk = new ArrayList<>();

    public BarangMasuk(String kodeBarang, String namaBarang, String satuanBarang, int jumlahBarang, LocalDate tglBarangMasuk){
        super(namaBarang, kodeBarang, satuanBarang, jumlahBarang);
        this.tglBarangMasuk = tglBarangMasuk;
    }

    public LocalDate getTglBarangMasuk() {
        return tglBarangMasuk;
    }

    public void setTglBarangMasuk(LocalDate tglBarangMasuk) {
        this.tglBarangMasuk = tglBarangMasuk;
    }

    public void tambahBarangKeluar(Barang barang, Date tglBarangKeluar) {
        daftarBarangMasuk.add(barang);
    }

    @Override
    public String toString() {
        return "Barang masuk berhasil ditambahkan";
    }
}