package utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtils {

    private Pane view;
    protected static Connection connection;

    //a method to change between scenes
    public static void changeScene(ActionEvent event, String fxmlFile) {

        Parent root = null;

        try {
            FXMLLoader loader = new FXMLLoader(DataBaseUtils.class.getResource(fxmlFile));
            root = loader.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

        //center all the windows after changing scene - !!CHANGE!!
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

    //a method to embed a fxml file in another
    public Pane getPage(String fileName){
        try{
            URL fileUrl = Main.class.getResource("/views/" + fileName + ".fxml");
            if(fileUrl == null) throw new java.io.FileNotFoundException("FXML file can't be found");
            view = new FXMLLoader().load(fileUrl);
        }
        catch (Exception e){
            System.out.println("No page found");
        }
        return view;
    }

    public static void connectToDataBase()
    {
        connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/librarysys", "root", "");
            System.out.println("Successfully connected to the database");
        }
        catch (SQLException e) {
            System.out.println("Could not connect to the database!");
        }
    }
}
