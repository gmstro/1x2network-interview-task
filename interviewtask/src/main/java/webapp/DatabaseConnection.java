package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Establish database connection and build/execute select query
 */
public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/interview?serverTimezone=GMT&useLegacyDatetimeCode=false";
            connection = DriverManager.getConnection(url, "root", "passwd");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Build and execute select query
    protected List<String> select(String value, String query) {

        List<String> result = new ArrayList<String>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM bets WHERE " + value + "=?");
            st.setString(1, query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                // build the string
                String res = String.format("%-5s%-10s%-12s%-10s%-10s%-12s%-5s",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
                result.add(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
