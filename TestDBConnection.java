import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;

public class TestDBConnection {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "SELECT DATABASE()";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String dbName = rs.getString(1);
                System.out.println("Connected to database: " + dbName);
            } else {
                System.out.println("No database selected");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
