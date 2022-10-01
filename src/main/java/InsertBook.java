import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBook {
    public static void insertB(String title, String author, int quantity){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db", "postgres", "4678");
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("insert into books (title,author,quantity) values (" + "'" + title + "'" + "," + "'" + author+ "'" + "," + "'" + quantity + "'" + ")");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
