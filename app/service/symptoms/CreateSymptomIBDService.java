package service.symptoms;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.SymptomDao;
import persistence.entities.SymptomEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;

import javax.inject.Inject;

public class CreateSymptomIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateSymptomIBDService.class);

    private SymptomDao symptomDao;

    @Inject
    public CreateSymptomIBDService(SymptomDao symptomDao)
    {
        this.symptomDao = symptomDao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        SymptomEntity symptom = getSymptomEntity(jsonRequest);

        symptomDao.create(symptom);

        return jsonRequest;
    }

    private SymptomEntity getSymptomEntity(JsonNode jsonRequest)
    {
        SymptomEntity symptom = new SymptomEntity();
        symptom.setName(jsonRequest.findPath(IBDApplicationConstants.SYMPTOM_JSON_STATUS_NAME).textValue());
        symptom.setInformation(jsonRequest.findPath(IBDApplicationConstants.SYMPTOM_JSON_INFORMATION).textValue());
        return symptom;
    }
}
