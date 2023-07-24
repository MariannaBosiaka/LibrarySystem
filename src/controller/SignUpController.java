package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.DataBaseUtils;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SignUpController extends DataBaseUtils implements Initializable {

    @FXML
    private TextField emailFieldSignUp;

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

        String insertDataSignUp = "INSERT INTO user(username, email, password) VALUES(?, ?, ?)";

        //add buttons to arraylist
        Controller.buttons.add(exitButtonSignUp);
        Controller.buttons.add(signUpButton);

        //add textfields to arraylist
        Controller.textfields.add(emailFieldSignUp);
        Controller.textfields.add(usernameFieldSignUp);
        Controller.textfields.add(passwordFieldSignUp);

        Controller.setCursorToHand(Controller.buttons);

        Controller.textFieldsStyle(Controller.textfields);

        Controller.exitFromApplication(exitButtonSignUp);//to exit from sign up scene

        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    PreparedStatement preparedStatement = connection.prepareStatement(insertDataSignUp);
                    preparedStatement.setString(1, usernameFieldSignUp.getText());
                    preparedStatement.setString(2, emailFieldSignUp.getText());
                    preparedStatement.setString(3, passwordFieldSignUp.getText());
                    System.out.println("added information to database");

                    preparedStatement.execute();
                    
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        logInLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "../views/logIn.fxml");
            }
        });
    }


}