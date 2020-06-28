import java.io.*;
import java.sql.*;

import com.mysql.cj.jdbc.JdbcConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import webapp.DatabaseConnection;

/**
 * Populate the database with contents of bets.json
 */
public class PopulateDatabase {

    private static final DatabaseConnection dbConnection = new DatabaseConnection();

    public static void main(String[] args) throws FileNotFoundException {

        JSONParser jsonParser = new JSONParser();
        Connection connection = dbConnection.getConnection();

        try {
            //Parse the contents of the JSON file to array
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(new File(
                    "src/resources/bets.json")));
            JSONArray jsonArray = (JSONArray) jsonObject.get("bets");

            //Insert data into bets table
            PreparedStatement st = connection.prepareStatement("INSERT INTO bets values (?, ?, ?, ?, ?, ?, ? )");
            for(Object object : jsonArray) {
                JSONObject record = (JSONObject) object;
                Long id = (Long) record.get("id");
                Long numbets = (Long) record.get("numbets");
                String game = (String) record.get("game");
                Double stake = (Double) record.get("stake");
                Double returns = (Double) record.get("returns");
                Long clientid = (Long) record.get("clientid");
                String date = (String) record.get("date");

                st.setLong(1, id);
                st.setLong(2, numbets);
                st.setString(3, game);
                st.setDouble(4, stake);
                st.setDouble(5, returns);
                st.setLong(6, clientid);
                st.setString(7, date);
                st.executeUpdate();
            }
            System.out.println("Records inserted.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
