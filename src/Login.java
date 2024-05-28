import com.tubespbo.dao.UserDao;
import com.tubespbo.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Hyperlink daftarButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField textfield1;

    @FXML
    private PasswordField textfield2;

    @FXML
    void daftarAkun(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Daftar.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginAkun(ActionEvent event) throws IOException {
        String username = textfield1.getText();
        String password = textfield2.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Username dan Password harus diisi.");
            return;
        }

        UserDao userDao = new UserDao();
        User user = userDao.login(username, password);

        if (user != null) {
            // Jika login berhasil, alihkan ke menu utama
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            // Jika login gagal, tampilkan pesan kesalahan
            showAlert("Error", "Username atau Password salah.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

