import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;

public class HomeWork1 {
    private static Logger logger = LoggerFactory.getLogger(HomeWork1.class);

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();

        try {
            fibonacci.doFibonachi();
        }catch (InputMismatchException e) {
            System.out.println("Please,enter a number");
        }

        long timeSpent = System.currentTimeMillis() - startTime;
        logger.info("Working time: " + timeSpent + " ms.");
    }
}
