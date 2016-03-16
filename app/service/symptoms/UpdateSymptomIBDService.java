package service.symptoms;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.SymptomDao;
import persistence.entities.SymptomEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;

import javax.inject.Inject;

public class UpdateSymptomIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(UpdateSymptomIBDService.class);

    private SymptomDao symptomDao;

    @Inject
    public UpdateSymptomIBDService(SymptomDao symptomDao)
    {
        this.symptomDao = symptomDao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        SymptomEntity symptom = getSymptomEntity(jsonRequest);

        symptomDao.update(symptom);

        return jsonRequest;
    }

    private SymptomEntity getSymptomEntity(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDApplicationConstants.SYMPTOM_JSON_ID_PROPERTY).textValue());

        SymptomEntity symptom = symptomDao.find(id);

        symptom.setName(jsonRequest.findPath(IBDApplicationConstants.SYMPTOM_JSON_STATUS_NAME).textValue());

        symptom.setInformation(jsonRequest.findPath(IBDApplicationConstants.SYMPTOM_JSON_INFORMATION).textValue());

        return symptom;
    }
}
