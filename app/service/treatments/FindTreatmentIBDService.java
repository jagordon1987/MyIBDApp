package service.treatments;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.TreatmentDao;
import persistence.entities.TreatmentEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class FindTreatmentIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(FindTreatmentIBDService.class);

    private TreatmentDao treatmentDao;

    private JSONUtil jsonUtil;

    @Inject
    public FindTreatmentIBDService(TreatmentDao treatmentDao, JSONUtil jsonUtil)
    {
        this.treatmentDao = treatmentDao;
        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDApplicationConstants.TREATMENT_JSON_ID_PROPERTY).textValue());

        TreatmentEntity treatment = treatmentDao.find(id);

        return jsonUtil.toJson(treatment);
    }
}
