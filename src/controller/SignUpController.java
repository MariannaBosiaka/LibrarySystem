package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.DataBaseUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController extends DataBaseUtils implements Initializable {

    @FXML
    private PasswordField emailFieldSignUp;

    @FXML
    private Button exitButtonSignUp;

    @FXML
    private Hyperlink logInLink;

    @FXML
    private PasswordField passwordFieldSignUp;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameFieldSignUp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "../views/logIn.fxml");
            }
        });
    }
}