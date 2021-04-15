package Week_1.A1.Singleton;

import java.sql.*;
/**
 * @author  Jonathan Frey
 */
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
}

