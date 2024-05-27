package com.tubespbo.model;

import java.util.ArrayList;
import java.util.List;

public class ManajemenGudang {
    private List<Barang> daftarBarang;
    public ManajemenGudang() {
        this.daftarBarang = new ArrayList<>();
    }

    public List<Barang> getDaftarBarang() {
        return daftarBarang;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public void hapusBarang(Barang barang) {
        daftarBarang.remove(barang);
    }

    public Barang cariBarang(String kodeBarang) {
        for (Barang barang : daftarBarang){
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }

    public void updateBarang(Barang barangLama, Barang barangBaru) {
        int index = daftarBarang.indexOf(barangLama);
        if (index != -1) {
            daftarBarang.set(index, barangBaru);
        }
    }
}