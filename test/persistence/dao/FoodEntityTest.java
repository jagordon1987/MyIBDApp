package persistence.dao;

import org.junit.*;
import persistence.entities.FoodEntity;

public class FoodEntityTest {
    private FoodEntity foodEntity = new FoodEntity();

    @Before
    public void before()
    {
        foodEntity.setId(1L);
        foodEntity.setName("Apple");
        foodEntity.setInformation("Disgusting");
    }

    @Test
    public void idTest()
    {
        Assert.assertTrue(foodEntity.getId() == 1L);
    }

    @Test
    public void foodNameTest()
    {
        Assert.assertEquals(foodEntity.getName(), "Apple");
    }

    @Test
    public void foodInformationTest()
    {
        Assert.assertEquals(foodEntity.getInformation(), "Disgusting");
    }
}
