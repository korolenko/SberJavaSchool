package Dao;

import Entities.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoTest {

    private ProductDao productDao;
    private Product product;

    @Mock
    private EntityManagerFactory entityManagerFactory;

    @Mock
    private EntityTransaction entityTransaction;

    @Mock
    private EntityManager entityManager;

    @Before
    public void setUp(){
        product = new Product("testMaker", "testModel", "testType");
        Mockito.when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
        Mockito.when(entityManager.getTransaction()).thenReturn(entityTransaction);
        productDao = new ProductDao(entityManager);
    }

    @Test
    public void testInsertProduct(){
        this.productDao.insertProduct(product);

        Mockito.verify(entityManager, times(1)).getTransaction();
        Mockito.verify(entityTransaction, times(1)).begin();
        Mockito.verify(entityManager, times(1)).persist(product);
        Mockito.verify(entityTransaction, times(1)).commit();
        Mockito.verify(entityManager, times(1)).close();
    }
}
