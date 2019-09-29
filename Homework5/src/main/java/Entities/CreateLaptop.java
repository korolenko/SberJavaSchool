package Entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateLaptop {
    public static Laptop createLaptop() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("laptop model:..");
        String model = scanner.nextLine();
        System.out.println("laptop ram:..");
        int ram = scanner.nextInt();
        System.out.println("laptop price:..");
        int price = scanner.nextInt();
        System.out.println("laptop screen:..");
        int screen = scanner.nextInt();
        return new Laptop(model,ram,price,screen);
    }
}
