package service.treatments;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.TreatmentDao;
import persistence.entities.TreatmentEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;

import javax.inject.Inject;

public class CreateTreatmentIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateTreatmentIBDService.class);

    private TreatmentDao treatmentDao;

    @Inject
    public CreateTreatmentIBDService(TreatmentDao treatmentDao)
    {
        this.treatmentDao = treatmentDao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        TreatmentEntity treatment = getTreatmentEntity(jsonRequest);

        treatmentDao.create(treatment);

        return jsonRequest;
    }

    private TreatmentEntity getTreatmentEntity(JsonNode jsonRequest)
    {
        TreatmentEntity treatment = new TreatmentEntity();
        treatment.setName(jsonRequest.findPath(IBDApplicationConstants.TREATMENT_JSON_STATUS_NAME).textValue());
        treatment.setInformation(jsonRequest.findPath(IBDApplicationConstants.TREATMENT_JSON_INFORMATION).textValue());
        return treatment;
    }
}
