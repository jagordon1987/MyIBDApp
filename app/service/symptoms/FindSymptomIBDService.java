package service.symptoms;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.SymptomDao;
import persistence.entities.SymptomEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class FindSymptomIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(FindSymptomIBDService.class);

    private SymptomDao symptomDao;

    private JSONUtil jsonUtil;

    @Inject
    public FindSymptomIBDService(SymptomDao symptomDao, JSONUtil jsonUtil)
    {
        this.symptomDao = symptomDao;
        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDApplicationConstants.SYMPTOM_JSON_ID_PROPERTY).textValue());

        SymptomEntity symptom = symptomDao.find(id);

        return jsonUtil.toJson(symptom);
    }
}
