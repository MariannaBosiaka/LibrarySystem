package controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import utils.DataBaseUtils;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.util.ArrayList;


public class LoginController extends DataBaseUtils implements Initializable {

    @FXML
    private Button exitButton, logInButton; //button
    @FXML
    private PasswordField passwordFieldLogin;
    @FXML
    private TextField usernameFieldLogin;
    @FXML
    private Hyperlink signUpLink;
    @FXML
    private Hyperlink loginLink;

    private String loginQueries; //this string will contain login queries

    private ArrayList<Button> buttons = new ArrayList<>(); //this list contains all the buttons of a scene
    private ArrayList<TextField> textFields = new ArrayList<>(); //this list contains all the textfields of a scene

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Controller.setCursorToHand(exitButton, logInButton);

        usernameFieldLogin.styleProperty().bind(
                Bindings
                        .when(usernameFieldLogin.focusedProperty())
                        .then("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);")
                        .otherwise("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);"));

        passwordFieldLogin.styleProperty().bind(
                Bindings
                        .when(usernameFieldLogin.focusedProperty())
                        .then("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);")
                        .otherwise("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);"));


        Controller.exitFromApplication(exitButton); //

        logInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //DataBaseUtils.changeScene(event, "../views/dashboard.fxml"); //DELETE LATER
                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from user");
                    while(resultSet.next()){
                        System.out.println(resultSet.getString(1)+" "+ resultSet.getString(2));
                        if(usernameFieldLogin.getText().equals(resultSet.getString(1))
                                &&passwordFieldLogin.getText().equals(resultSet.getString(2))){
                            System.out.println("Logged in");
                            DataBaseUtils.changeScene(event, "../views/dashboard.fxml");
                        }
                        else{
                            System.out.println("This user doesn't exist");
                        }

                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        signUpLink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DataBaseUtils.changeScene(event, "../views/signUp.fxml");
            }
        });
//        loginLink.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                DataBaseUtils.changeScene(event, "../views/logIn.fxml");
//            }
//        });
    }
}
