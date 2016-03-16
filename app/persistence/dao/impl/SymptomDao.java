package persistence.dao.impl;

import persistence.dao.Dao;
import persistence.entities.SymptomEntity;
import util.play.EntityManagerUtility;

import javax.inject.Inject;

public class SymptomDao extends Dao<SymptomEntity>
{
    @Inject
    public SymptomDao(EntityManagerUtility emp)
    {
        super(emp);
    }
}
