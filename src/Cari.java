import com.tubespbo.connection.Koneksi;
import com.tubespbo.model.Barang;
import  com.tubespbo.dao.ManajemenGudangDao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Cari {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ManajemenGudangDao manajemenGudangDao;
    private Connection connection;


    @FXML
    private TableColumn<Barang, Integer> jumlahBarangColumn;

    @FXML
    private TableColumn<Barang, String> kodeBarangColumn;

    @FXML
    private TableColumn<Barang, String> namaBarangColumn;

    @FXML
    private TableColumn<Barang, String> satuanBarangColumn;

    @FXML
    private MenuItem barangKeluarMenuItem;

    @FXML
    private MenuItem barangMasukMenuItem;

    @FXML
    private MenuItem cariBarangMenuItem;

    @FXML
    private Button cariButton;

    @FXML
    private MenuItem editBarangMenuItem;

    @FXML
    private Button editButton;

    @FXML
    private MenuItem hapusBarangMenuItem;

    @FXML
    private Button hapusButton;

    @FXML
    private MenuBar menu;

    @FXML
    private MenuItem menuUtamaxMenuItem;

    @FXML
    private MenuItem tambahBarangMenuItem;

    @FXML
    private Button tambahButton;

    @FXML
    private TextField textfield;

    @FXML
    private TableView<Barang> barangTableView;

    private Barang selectedBarang;


    @FXML
    void initialize() {
        manajemenGudangDao = new ManajemenGudangDao(Koneksi.getConnection());
        // Set cellValueFactory untuk setiap kolom
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

        barangTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedBarang = newSelection;
            }
        });
    }
  
    @FXML
    void cariBarang(ActionEvent event) {
        String namaBarang = textfield.getText();
        List<Barang> hasilPencarian = manajemenGudangDao.cariBarang(namaBarang);

        // Menghapus data lama dari TableView
        barangTableView.getItems().clear();

        // Menambahkan data baru ke dalam TableView
        for (Barang barang : hasilPencarian) {
            barangTableView.getItems().add(barang);
        }
    }


    @FXML
    void editBarang(ActionEvent event) throws IOException {
        if (selectedBarang == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Harap Pilih Barang Terlebih Dahulu.");
            alert.showAndWait();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"));
            Parent root = loader.load();

            // Pass the selected barang to the Edit controller
            Edit editController = loader.getController();
            editController.setBarang(selectedBarang);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void hapusBarang(ActionEvent event) throws IOException, SQLException {
        if (selectedBarang == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Harap Pilih Barang Terlebih Dahulu.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Anda Yakin Ingin Menghapus Barang?");

            if (alert.showAndWait().get() == ButtonType.OK) {
                manajemenGudangDao.hapusBarang(selectedBarang.getKodeBarang());

                // Refresh the table view
                List<Barang> daftarBarang = manajemenGudangDao.getDaftarBarang();
                ObservableList<Barang> dataBarang = FXCollections.observableArrayList(daftarBarang);
                barangTableView.setItems(dataBarang);
            }
        }
    }

    @FXML
    void tambahBarang(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Tambah.fxml"));
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
