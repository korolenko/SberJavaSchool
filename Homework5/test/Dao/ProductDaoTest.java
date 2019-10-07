package Dao;

import Entities.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class ProductDaoTest {

    @Mock
    private EntityTransaction transaction;

    @Mock
    private EntityManager entityManager;

    @Mock
    private ProductDao productDao;
    @Mock
    private Product product;

    @Before
    public void init(){
        //doNothing().when(transaction).commit();
        //Mockito.when(this.entityManager.find(Product.class, 2)).thenReturn(this.product);
        //doNothing().when(this.product).setModel("test");
        //doNothing().when(entityManager).close();
        //productDao = Mockito.mock(ProductDao.class);
    }

    @Test
    public void testUpdateProduct() {
        productDao = new ProductDao(entityManager);
        //Mockito.when(this.entityManager.find(Product.class, 2)).thenReturn(this.product);
        //doNothing().when(productDao).updateProduct(2, "testModel");
        verify(productDao).updateProduct(2,"testModel");
        //Mockito.verify(productDao, times(1)).updateProduct(2,"testModel");
    }

}