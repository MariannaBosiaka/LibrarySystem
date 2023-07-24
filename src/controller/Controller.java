//This is a class with functions for all scenes that have some similar functions - exit button, text-field functions etc

package controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utils.DataBaseUtils;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller extends DataBaseUtils implements Initializable {

    public static ArrayList<Button> buttons = new ArrayList<>();
    public static ArrayList<TextField> textfields = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //method to exit from application
    public static void exitFromApplication(Button exitButton){
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
    }

    //This method sets cursor to hand at hovering buttons - varying number of arguments
    public static void setCursorToHand(ArrayList<Button> buttons){
        for (Button button : buttons) {
            button.setCursor(Cursor.HAND);
        }
    }

    public static void textFieldsStyle(ArrayList<TextField> textfields){
        for(TextField textField: textfields){
            textField.styleProperty().bind(
                    Bindings
                            .when(textField.focusedProperty())
                            .then("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);")
                            .otherwise("-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);"));
        }
    }




}
