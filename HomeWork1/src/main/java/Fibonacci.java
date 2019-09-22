import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

    public void doFibonachi() throws InputMismatchException{
        int amount;
        System.out.println("Welcome to Fibonachi numbers creator!");
        while (true){
            System.out.println("\nPlease enter the amount of numbers or 999 for exit..");
            Scanner in = new Scanner(System.in);
            amount = in.nextInt();
            if(amount<0){
                System.out.println("Please, enter a number >=0");
            }
            else if(amount==999)
            {
                break;
            }
            else if(amount == 0){
                System.out.println("Fibonachi sequence is zero");
            }
            else {
                this.createFibonacciNumbers(amount);
            }
        }
    }
    //main logic
    private void createFibonacciNumbers(int amount) {
        int a, b, next;
        a = 0;
        b = 1;
        if(amount==1){
            System.out.println(a);
        }
        else {
            System.out.print(a + ", ");
            System.out.print(b + ", ");
            for (int i = 0; i < amount - 2; i++) {
                next = a + b;
                System.out.print(next + ", ");
                a = b;
                b = next;
            }
        }
    }
}
