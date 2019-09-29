import Dao.LaptopDao;
import Dao.ProductDao;
import Entities.CreateLaptop;
import Entities.CreateProduct;
import Entities.Laptop;
import Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MySQLConnection {

    public void select()throws InputMismatchException {
        System.out.println("Enter table name (product or laptop):..");
        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.nextLine();

        if(tableName.toUpperCase().equals("PRODUCT"))
        {
            ProductDao productDao = new ProductDao(getEntityManager());
            System.out.println(productDao.readAll().toString());
        }
        else if (tableName.toUpperCase().equals("LAPTOP"))
        {
            LaptopDao laptopDao = new LaptopDao(getEntityManager());
            System.out.println(laptopDao.readAll().toString());
        }
        else {
            throw new InputMismatchException();
        }
    }

    public void create()throws InputMismatchException{
        System.out.println("Enter table name (product or laptop):..");
        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.nextLine();

        if(tableName.toUpperCase().equals("PRODUCT"))
        {
            Product product = CreateProduct.createProduct();
            ProductDao productDao = new ProductDao(getEntityManager());
            productDao.insertProduct(product);
        }
        else if(tableName.toUpperCase().equals("LAPTOP"))
        {
            Laptop laptop = CreateLaptop.createLaptop();
            LaptopDao laptopDao = new LaptopDao(getEntityManager());
            laptopDao.insertLaptop(laptop);
        }
        else {
            throw new InputMismatchException();
        }
    }

    public void update()throws InputMismatchException {
        System.out.println("update Product set model:");
        System.out.println("Enter id:..");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter model:..");
        String model = scanner.nextLine();
        ProductDao productDao = new ProductDao(getEntityManager());
        productDao.updateProduct(id,model);
    }

    public void delete()throws InputMismatchException{
        System.out.println("Enter table name (product or laptop):..");
        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.nextLine();

        if(tableName.toUpperCase().equals("PRODUCT"))
        {
            System.out.println("delete Product where id =");
            System.out.println("Enter id:..");
            int id = scanner.nextInt();
            ProductDao productDao = new ProductDao(getEntityManager());
            productDao.deleteProduct(id);
        }
        else if(tableName.toUpperCase().equals("LAPTOP"))
        {
            System.out.println("delete Laptop where id =");
            System.out.println("Enter id:..");
            int id = scanner.nextInt();
            LaptopDao laptopDao = new LaptopDao(getEntityManager());
            laptopDao.deleteLaptop(id);
        }
        else {
            throw new InputMismatchException();
        }
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Entities");
        return entityManagerFactory.createEntityManager();
    }
}
