package LoginSystem;

import BackEnd.Fetcher;
import MainSystem.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label headerLBL;

    @FXML
    private TextField usernameTXT;

    @FXML
    private PasswordField pwdTXT;

    @FXML
    private Button loginBTN;

    @FXML
    private Button clearBTN;

    @FXML
    private Label statusLBL;

    @FXML
    void loginHandler(ActionEvent event) throws Exception {
        String name = usernameTXT.getText();
        String pass = pwdTXT.getText();
        if (!name.equals("") && !pass.equals("")) {
            statusLBL.setText("");
            statusLBL.setTextFill(Color.BLACK);
            boolean response = Fetcher.loginUser(name, pass);
            if (response) {
                statusLBL.setText("Login Successful !");
                statusLBL.setTextFill(Color.GREEN);

                Stage stage = (Stage) loginBTN.getScene().getWindow();
                stage.close();
                Stage stage2 = new Stage();
                MainApp mainApp = new MainApp();
                mainApp.start(stage2);

                //============//
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("User Info");
                alert.setHeaderText(null);
                alert.setContentText(String.format("Employee Name: %s, Username: %s, Password: %s", Fetcher.getEmpName(),
                        Fetcher.getUserName(), Fetcher.getUserName()));
                alert.showAndWait();
            } else {
                statusLBL.setText("Wrong Info");
                statusLBL.setTextFill(Color.RED);
            }
        } else {
            statusLBL.setText("Missing Info");
            statusLBL.setTextFill(Color.RED);
        }
    }

    @FXML
    void clearHandler(ActionEvent event) {
        pwdTXT.setText("");
        usernameTXT.setText("");
        statusLBL.setText("");
        statusLBL.setTextFill(Color.BLACK);
    }


}
