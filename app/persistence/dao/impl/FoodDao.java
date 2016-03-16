package persistence.dao.impl;

import persistence.dao.Dao;
import persistence.entities.FoodEntity;
import util.play.EntityManagerProvider;

import javax.inject.Inject;

public class FoodDao extends Dao<FoodEntity>
{
    @Inject
    public FoodDao(EntityManagerProvider emp)
    {
        super(emp);
    }
}
