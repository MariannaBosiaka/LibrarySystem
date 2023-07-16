import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        new Main();
    }

    public Main() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysys", "root", "m54#!br34A");
        System.out.println("Successfully connected to database");
    }
}
