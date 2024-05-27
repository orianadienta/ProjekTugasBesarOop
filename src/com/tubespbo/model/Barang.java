package com.tubespbo.model;

public class Barang {
    private String namaBarang;
    private String kodeBarang;
    private String satuanBarang;
    private int jumlahBarang;

    public Barang(String kodeBarang, String namaBarang, String satuanBarang, int jumlahBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.satuanBarang = satuanBarang;
        this.jumlahBarang = jumlahBarang;
    }
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getSatuanBarang() {
        return satuanBarang;
    }

    public void setSatuanBarang(String satuanBarang) {
        this.satuanBarang = satuanBarang;
    }

    public Integer getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(Integer jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String toString() {
        return "Barang berhasil ditambahkan";
    }

    public void logBarang() {
        System.out.println(toString());
    }
}