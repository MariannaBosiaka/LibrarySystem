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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginController extends DataBaseUtils implements Initializable {

    @FXML
    private Button exitButton, logInButton; //button
    @FXML
    private PasswordField passwordFieldLogin;
    @FXML
    private TextField usernameFieldLogin;

    private String loginQueries; //this string will contain login queries




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
    }




}
