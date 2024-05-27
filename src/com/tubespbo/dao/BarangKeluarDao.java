package com.tubespbo.dao;

import com.tubespbo.connection.Koneksi;
import com.tubespbo.model.BarangKeluar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangKeluarDao {
    private static Connection connection;

    public BarangKeluarDao(Connection connection) {
        this.connection = connection;
    }

    public static List<BarangKeluar> getAllBarangKeluar() throws SQLException {
        List<BarangKeluar> daftarBarang = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tbbarangkeluar WHERE 1");
            while (resultSet.next()) {
                BarangKeluar barangKeluar = new BarangKeluar(resultSet.getString("KodeBarang"),
                        resultSet.getString("NamaBarang"),
                        resultSet.getString("SatuanBarang"),
                        resultSet.getInt("JumlahBarang"),
                        resultSet.getDate("TglBarangKeluar").toLocalDate());

                daftarBarang.add(barangKeluar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return daftarBarang;
    }

    public void tambahBarangKeluar(BarangKeluar barangKeluar) {
        try {
            Connection connection = Koneksi.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tbbarangkeluar (KodeBarang, NamaBarang, SatuanBarang, JumlahBarang, TglBarangKeluar) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, barangKeluar.getKodeBarang());
            preparedStatement.setString(2, barangKeluar.getNamaBarang());
            preparedStatement.setString(3, barangKeluar.getSatuanBarang());
            preparedStatement.setInt(4, barangKeluar.getJumlahBarang());
            preparedStatement.setDate(5, java.sql.Date.valueOf(barangKeluar.getTglBarangKeluar()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}