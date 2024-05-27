import com.tubespbo.dao.UserDao;
import com.tubespbo.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Daftar {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button daftarButton;

    @FXML
    private TextField textfield1;

    @FXML
    private PasswordField textfield2;

    @FXML
    public void daftarAkun(ActionEvent event) throws IOException {
        String username = textfield1.getText();
        String password = textfield2.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Username dan Password harus diisi.");
            return;
        }

        UserDao userDao = new UserDao();
        User user = new User(username, password);
        userDao.register(user);

        // Setelah registrasi berhasil, alihkan ke halaman login
        showAlert("Success", "Registrasi berhasil. Silakan login.");
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
