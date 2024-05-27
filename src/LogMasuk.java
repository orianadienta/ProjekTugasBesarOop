import com.tubespbo.connection.Koneksi;
import com.tubespbo.dao.BarangMasukDao;
import com.tubespbo.model.Barang;
import com.tubespbo.model.BarangMasuk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class LogMasuk {

    private BarangMasukDao barangMasukDao;

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
    private MenuItem menuUtamaxMenuItem;

    @FXML
    private TableView<Barang> barangMasukTableView;

    @FXML
    private TableColumn<BarangMasuk, String> kodeBarangColumn;

    @FXML
    private TableColumn<BarangMasuk, String> namaBarangColumn;

    @FXML
    private TableColumn<BarangMasuk, String> satuanBarangColumn;

    @FXML
    private TableColumn<BarangMasuk, Integer> jumlahBarangColumn;

    @FXML
    private TableColumn<BarangMasuk, LocalDate> tglMasukColumn;

    @FXML
    private MenuItem tambahBarangMenuItem;

    @FXML
    private Button tambahButton;

    //inisiasi kolom pada tbleview sesuai dengan objek barang
    @FXML
    private void initialize() {
        kodeBarangColumn.setCellValueFactory(new PropertyValueFactory<>("kodeBarang"));
        namaBarangColumn.setCellValueFactory(new PropertyValueFactory<>("namaBarang"));
        satuanBarangColumn.setCellValueFactory(new PropertyValueFactory<>("satuanBarang"));
        jumlahBarangColumn.setCellValueFactory(new PropertyValueFactory<>("jumlahBarang"));
        tglMasukColumn.setCellValueFactory(new PropertyValueFactory<>("tglBarangMasuk"));

        try {
            // Mengambil data dari database
            List<BarangMasuk> daftarBarang = BarangMasukDao.getAllBarangMasuk();

            // Mengatur data ke dalam TableView
            ObservableList<Barang> dataBarangMasuk = FXCollections.observableArrayList(daftarBarang);
            barangMasukTableView.setItems(dataBarangMasuk);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LogMasuk() throws SQLException {
        Connection connection = Koneksi.getConnection();
        barangMasukDao = new BarangMasukDao(connection);
    }

    @FXML
    void tambahData(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TambahBarangMasuk.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
