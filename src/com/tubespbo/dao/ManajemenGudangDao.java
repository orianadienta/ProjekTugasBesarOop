package com.tubespbo.dao;

import com.tubespbo.connection.Koneksi;
import com.tubespbo.model.Barang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ManajemenGudangDao {
    private static Connection connection;

    public ManajemenGudangDao(Connection connection) {
        this.connection = connection;
    }



    public static List<Barang> getDaftarBarang() throws SQLException {
        List<Barang> daftarBarang = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tblistbarang WHERE 1");
            while (resultSet.next()) {
                Barang barang = new Barang(resultSet.getString("KodeBarang"),
                        resultSet.getString("NamaBarang"),
                        resultSet.getString("SatuanBarang"),
                        resultSet.getInt("JumlahBarang"));

                daftarBarang.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarBarang;
    }


    public void tambahBarang(Barang barang) throws SQLException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tblistbarang (KodeBarang, NamaBarang, SatuanBarang, JumlahBarang) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, barang.getKodeBarang());
            preparedStatement.setString(2, barang.getNamaBarang());
            preparedStatement.setString(3, barang.getSatuanBarang());
            preparedStatement.setInt(4, barang.getJumlahBarang());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Melempar eksepsi agar dapat ditangani oleh pemanggil
        }
    }

    public void hapusBarang(String kodeBarang) {
        try {
            Connection connection = Koneksi.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM tblistbarang WHERE KodeBarang = ?");
            preparedStatement.setString(1, kodeBarang);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Barang> cariBarang(String namaBarang) {
        List<Barang> hasilPencarian = new ArrayList<>();
        try {
            Connection connection = Koneksi.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tblistbarang WHERE NamaBarang LIKE ?");
            preparedStatement.setString(1, "%" + namaBarang + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Barang barang = new Barang(resultSet.getString("KodeBarang"),
                        resultSet.getString("NamaBarang"),
                        resultSet.getString("SatuanBarang"),
                        resultSet.getInt("JumlahBarang"));
                hasilPencarian.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasilPencarian;
    }


    public static void editBarang(Barang barang) {
        try {
            Connection connection = Koneksi.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tblistbarang SET NamaBarang = ?, SatuanBarang = ?, JumlahBarang = ? WHERE KodeBarang = ?");
            preparedStatement.setString(1, barang.getNamaBarang());
            preparedStatement.setString(2, barang.getSatuanBarang());
            preparedStatement.setInt(3, barang.getJumlahBarang());
            preparedStatement.setString(4, barang.getKodeBarang());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}