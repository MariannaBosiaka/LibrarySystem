package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import utils.DataBaseUtils;


import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class LoginController extends DataBaseUtils implements Initializable {

    @FXML
    private Button exitButton, logInButton; //button
    @FXML
    private PasswordField passwordFieldLogin;
    @FXML
    private TextField usernameFieldLogin;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exitButton.setCursor(Cursor.HAND);
        logInButton.setCursor(Cursor.HAND);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                System.exit(0);
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        logInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.connectToDataBase();
                //if(passwordFieldLogin.getText());

            }
        });
    }




}
