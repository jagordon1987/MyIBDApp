package service.treatments;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.TreatmentDao;
import persistence.entities.TreatmentEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;
import java.util.List;

public class ListTreatmentIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListTreatmentIBDService.class);

    private TreatmentDao treatmentDao;

    private JSONUtil jsonUtil;

    @Inject
    public ListTreatmentIBDService(TreatmentDao treatmentDao, JSONUtil jsonUtil)
    {
        this.treatmentDao = treatmentDao;

        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<TreatmentEntity> treatments = treatmentDao.list();

        return jsonUtil.toJson(treatments);
    }
}
