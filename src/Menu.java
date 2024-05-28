import com.tubespbo.connection.Koneksi;
import com.tubespbo.dao.ManajemenGudangDao;
import com.tubespbo.model.Barang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Menu {
    private ManajemenGudangDao manajemenGudangDao;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private MenuItem barangKeluarMenuItem;

    @FXML
    private MenuItem barangMasukMenuItem;

    @FXML
    private MenuItem cariBarangMenuItem;

    @FXML
    private MenuItem editBarangMenuItem;

    @FXML
    private MenuItem hapusBarangMenuItem;

    @FXML
    private MenuBar menu;

    @FXML
    private MenuItem menuUtamaxMenuItem;

    @FXML
    private MenuItem tambahBarangMenuItem;

    @FXML
    private TableView<Barang> barangTableView;

    @FXML
    private TableColumn<Barang, String> kodeBarangColumn;

    @FXML
    private TableColumn<Barang, String> namaBarangColumn;

    @FXML
    private TableColumn<Barang, String> satuanBarangColumn;

    @FXML
    private TableColumn<Barang, Integer> jumlahBarangColumn;

    //inisiasi kolom pada tbleview sesuai dengan objek barang
    @FXML
    private void initialize() {
        kodeBarangColumn.setCellValueFactory(new PropertyValueFactory<>("kodeBarang"));
        namaBarangColumn.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
        satuanBarangColumn.setCellValueFactory(new PropertyValueFactory<>("satuanBarang"));
        jumlahBarangColumn.setCellValueFactory(new PropertyValueFactory<>("jumlahBarang"));

        try {
            // Mengambil data dari database
            List<Barang> daftarBarang = manajemenGudangDao.getDaftarBarang();

            // Mengatur data ke dalam TableView
            ObservableList<Barang> dataBarang = FXCollections.observableArrayList(daftarBarang);
            barangTableView.setItems(dataBarang);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Menu() throws SQLException {
        Connection connection = Koneksi.getConnection();
        manajemenGudangDao = new ManajemenGudangDao(connection);
    }

    @FXML
    void menujuBarangMasuk(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LogMasuk.fxml"));
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menujuBarangkeluar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LogKeluar.fxml"));
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menujuCari(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Cari.fxml"));
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menujuEdit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Edit.fxml"));
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menujuHapus(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Hapus.fxml"));
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menujuMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        try {
            // mendapat barang dari data base
            List<Barang> daftarBarang = ManajemenGudangDao.getDaftarBarang();
            // menampilkan daftar barang di tablevie
            barangTableView.getItems().setAll(daftarBarang);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void menujuTambah(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Tambah.fxml"));
        stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}