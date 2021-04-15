package Week_1.Week1_day4;

/**
 * @author  Jonathan Frey
 * Doubled checked locking Singleton
 */
public class doubleCheckedLockedSingleton {
    private static volatile doubleCheckedLockedSingleton instance;

    public static synchronized doubleCheckedLockedSingleton getInstance() {
        if (instance == null) {
            synchronized (doubleCheckedLockedSingleton.class){
                if(instance == null) instance = new doubleCheckedLockedSingleton();
            }
        }
        return instance;
    }
}