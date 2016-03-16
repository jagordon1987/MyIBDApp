package persistence.dao.impl;

import persistence.dao.Dao;
import persistence.entities.TreatmentEntity;
import util.play.EntityManagerUtility;

import javax.inject.Inject;

public class TreatmentDao extends Dao<TreatmentEntity>
{
    @Inject
    public TreatmentDao(EntityManagerUtility emp)
    {
        super(emp);
    }
}
