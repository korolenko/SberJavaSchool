package Dao;

import Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.InputMismatchException;
import java.util.List;

public class ProductDao {
    private EntityManager entityManager;

    public ProductDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void insertProduct(Product product) throws InputMismatchException {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
        entityManager.close();
    }

    public List readAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        List products = entityManager
                .createQuery("SELECT p FROM Product p") // select * from mentor
                .getResultList();
        transaction.commit();
        return products;
    }
    public void updateProduct(int id, String model) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Product product = entityManager.find(Product.class, id);
        product.setModel(model);
        transaction.commit();
        entityManager.close();
    }

    public void deleteProduct(int id){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);
        transaction.commit();
        entityManager.close();
    }
}
