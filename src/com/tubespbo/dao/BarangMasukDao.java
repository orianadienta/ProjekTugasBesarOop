package com.tubespbo.dao;

import com.tubespbo.connection.Koneksi;
import com.tubespbo.model.BarangMasuk;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangMasukDao {
    private static Connection connection;

    public BarangMasukDao(Connection connection) {
        this.connection = connection;
    }

    public static List<BarangMasuk> getAllBarangMasuk() throws SQLException {
        List<BarangMasuk> daftarBarang = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tbbarangmasuk WHERE 1");
            while (resultSet.next()) {
                BarangMasuk barangMasuk = new BarangMasuk(resultSet.getString("KodeBarang"),
                        resultSet.getString("NamaBarang"),
                        resultSet.getString("SatuanBarang"),
                        resultSet.getInt("JumlahBarang"),
                        resultSet.getDate("TglBarangMasuk").toLocalDate());

                daftarBarang.add(barangMasuk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarBarang;
    }

    public void tambahBarangMasuk(BarangMasuk barangMasuk) {
        try {
            Connection connection = Koneksi.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tbbarangmasuk (KodeBarang, NamaBarang, SatuanBarang, JumlahBarang, TglBarangMasuk) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, barangMasuk.getKodeBarang());
            preparedStatement.setString(2, barangMasuk.getNamaBarang());
            preparedStatement.setString(3, barangMasuk.getSatuanBarang());
            preparedStatement.setInt(4, barangMasuk.getJumlahBarang());
            preparedStatement.setDate(5, java.sql.Date.valueOf(barangMasuk.getTglBarangMasuk()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}