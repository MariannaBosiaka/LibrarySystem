package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utils.DataBaseUtils;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    private Button logInButton;
    @FXML
    private TextField usernameLogin;
    @FXML
    private TextField passwordLogin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                //connect to the database - after the button has been pressed
                DataBaseUtils.connectToDataBase(actionEvent, usernameLogin.getText(), passwordLogin.getText());
                //DataBaseUtils.changeScene(actionEvent, "../views/main.fxml");
            }
        });
    }


}
