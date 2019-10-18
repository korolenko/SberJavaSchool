package homework8.service;

import homework8.dta.LaptopDTO;
import homework8.models.LaptopEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaptopServiceIntegrationTest {

    @Autowired
    private LaptopService laptopService;

    @Test
    public void saveTest(){

        LaptopDTO testLaptopDTO = new LaptopDTO();
        testLaptopDTO.setPrice(233);
        LaptopEntity laptopEntity = laptopService.create(testLaptopDTO);

        LaptopDTO actual = laptopService.findById(laptopEntity.getId());
        Assert.assertEquals(233,actual.getPrice());
    }
}
