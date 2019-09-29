package Entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateProduct {
    public static Product createProduct() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("product maker:..");
        String maker = scanner.nextLine();
        System.out.println("product model:..");
        String model = scanner.nextLine();
        System.out.println("product type:..");
        String type = scanner.nextLine();
        return new Product(maker,model,type);
    }
}
