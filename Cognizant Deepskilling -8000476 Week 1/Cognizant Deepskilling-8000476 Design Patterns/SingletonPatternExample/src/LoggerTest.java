package SingletonPatternExample.src;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        logger1.log("This is a test message.");
        logger2.log("This should use the same singleton instance.");
    }
}

