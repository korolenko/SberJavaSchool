import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        int amount;
        System.out.println("Welcome to Fibonachi numbers creator!");
        while (true){
            System.out.println("\nPlease enter the amount of numbers or 999 for exit..");
            Scanner in = new Scanner(System.in);
            try {
                amount = in.nextInt();
                if(amount<0){
                    System.out.println("Please, enter a number >=0");
                    continue;
                }
                else if(amount==999)
                {
                    break;
                }
                else if(amount == 0){
                    System.out.println("Fibonachi sequence is zero");
                    continue;
                }
                else {
                    Fibonacci.createFibonacciNumbers(amount);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please,enter a number");
            }
        }
        BasicConfigurator.configure();
        Logger logger = LoggerFactory.getLogger(HomeWork1.class);
        long timeSpent = System.currentTimeMillis() - startTime;
        logger.info("Working time: " + timeSpent + " ms.");
    }
}
