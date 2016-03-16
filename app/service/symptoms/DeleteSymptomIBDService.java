package service.symptoms;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.SymptomDao;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class DeleteSymptomIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(DeleteSymptomIBDService.class);

    private SymptomDao symptomDao;

    private JSONUtil jsonUtil;

    @Inject
    public DeleteSymptomIBDService(SymptomDao symptomDao, JSONUtil jsonUtil)
    {
        this.symptomDao = symptomDao;

        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDApplicationConstants.SYMPTOM_JSON_ID_PROPERTY).textValue());

        symptomDao.delete(id);

        return jsonUtil.toJson("{\"message\":\"Deleted Symptom with the following id" + id + "\"}");
    }
}
