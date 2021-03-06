package persistence.dao.impl;

import persistence.dao.Dao;
import persistence.entities.FoodEntity;
import util.play.EntityManagerUtility;

import javax.inject.Inject;

public class FoodDao extends Dao<FoodEntity>
{
    @Inject
    public FoodDao(EntityManagerUtility emp)
    {
        super(emp);
    }
}
