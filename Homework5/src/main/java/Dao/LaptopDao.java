package Dao;

import Entities.Laptop;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class LaptopDao {
    private EntityManager entityManager;

    public LaptopDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void insertLaptop(Laptop laptop){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(laptop);
        transaction.commit();
        entityManager.close();
    }

    public List readAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        List laptops = entityManager
                .createQuery("SELECT l FROM Laptop l") // select * from mentor
                .getResultList();
        transaction.commit();
        return laptops;
    }

    public void deleteLaptop(int id){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Laptop laptop= entityManager.find(Laptop.class,id);
        entityManager.remove(laptop);
        transaction.commit();
        entityManager.close();
    }
}
