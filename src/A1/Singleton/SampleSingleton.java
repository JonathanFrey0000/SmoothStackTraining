package A1.Singleton;

import java.math.BigDecimal;
import java.sql.*;


public class SampleSingleton {

    private static volatile Connection conn = null;

    private static volatile SampleSingleton instance = null;

    public static SampleSingleton getInstance() {
        if (instance == null) {
            synchronized (SampleSingleton.class){
                if(instance == null) instance = new SampleSingleton();
            }
        }
        return instance;
    }

    public static void databaseQuery(BigDecimal input) throws SQLException {
        conn = DriverManager.getConnection("url of database");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select id from table");
        int x = 0;
        while(rs.next()) {
            x = rs.getInt(1) * input.intValue();
        }
    }
}

