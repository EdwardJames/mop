
public class Singleton {
    private static Singleton singleton= null;
    public static Singleton getInstance(){
        if(singleton==null)
            return new Singleton();
            return singleton;
    }
}
