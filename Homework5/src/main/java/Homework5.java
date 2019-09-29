import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args){
        System.out.println("~~~~~~Homework5~~~~~~");
        MySQLConnection mySQLConnection = new MySQLConnection();
        int menu = 0;
        while (menu!=999) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1 - select");
            System.out.println("2 - insert");
            System.out.println("3 - foreign key update");
            System.out.println("4 - delete");
            System.out.println("999 - exit");
            System.out.println("Enter number of action:..");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            try {
                Scanner menuScaner = new Scanner(System.in);
                menu = menuScaner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please,enter a number 1,2,3,4 or 999");
                continue;
            }
            try {
                switch (menu) {
                    case (1): {
                        mySQLConnection.select();
                        continue;
                    }
                    case (2): {
                        mySQLConnection.create();
                        continue;
                    }
                    case (3): {
                        mySQLConnection.update();
                        continue;
                    }
                    case (4): {
                        mySQLConnection.delete();
                        continue;
                    }
                    case (999): {
                        break;
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Wrong input");
            }
        }
    }
}
