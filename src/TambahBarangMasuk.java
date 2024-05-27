import com.tubespbo.connection.Koneksi;
import com.tubespbo.dao.BarangMasukDao;
import com.tubespbo.model.BarangMasuk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class TambahBarangMasuk {

    private BarangMasukDao dao;
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
    private Button simpanButton;

    @FXML
    private MenuItem tambahBarangMenuItem;

    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    private TextField textfield3;

    @FXML
    private TextField textfield4;

    @FXML
    private DatePicker datePicker;

    // Constructor untuk menginisialisasi objek ManajemenGudangDao
    public TambahBarangMasuk() {
        Connection connection = Koneksi.getConnection(); // Mendapatkan koneksi ke database
        dao = new BarangMasukDao(connection); // Menginisialisasi BarangMasukDao dengan koneksi
    }

    @FXML
    void simpanData(ActionEvent event) throws IOException, SQLException {
        // Mendapatkan data dari teks field
        String kodeBarang = textfield1.getText();
        String namaBarang = textfield2.getText();
        String satuanBarang = textfield3.getText();
        int jumlahBarang = Integer.parseInt(textfield4.getText());
        LocalDate tglBarangMasuk = datePicker.getValue();

        // Membuat objek Barang
        BarangMasuk barangMasuk = new BarangMasuk(kodeBarang, namaBarang, satuanBarang, jumlahBarang, tglBarangMasuk);
        // Memanggil metode tambahBarang dari objek ManajemenGudangDao
        {
            dao.tambahBarangMasuk(barangMasuk);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText(barangMasuk.toString());
            alert.showAndWait();

            root = FXMLLoader.load(getClass().getResource("LogMasuk.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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

    @FXML
    void tglBarangMasuk(ActionEvent event) {
    }
}
