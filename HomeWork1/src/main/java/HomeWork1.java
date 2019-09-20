import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeWork1 {
    private static Logger logger;

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.doFibonachi();
        BasicConfigurator.configure();
        logger = LoggerFactory.getLogger(HomeWork1.class);
        long timeSpent = System.currentTimeMillis() - startTime;
        logger.info("Working time: " + timeSpent + " ms.");
    }
}
