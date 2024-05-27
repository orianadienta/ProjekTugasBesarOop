import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Hapus {

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
    private Button hapusButton;

    @FXML
    private MenuBar menu;

    @FXML
    private MenuItem menuUtamaxMenuItem;

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
    void hapusBarang(ActionEvent event) throws IOException {
//nanti berarti di metod ini ada 2 action kan? logicmu sama pindah ke scene 'Cari'?
        root = FXMLLoader.load(getClass().getResource("Cari.fxml"));
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
