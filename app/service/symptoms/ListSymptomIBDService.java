package service.symptoms;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.SymptomDao;
import persistence.entities.SymptomEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;
import java.util.List;

public class ListSymptomIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListSymptomIBDService.class);

    private SymptomDao symptomDao;

    private JSONUtil jsonUtil;

    @Inject
    public ListSymptomIBDService(SymptomDao symptomDao, JSONUtil jsonUtil)
    {
        this.symptomDao = symptomDao;

        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<SymptomEntity> symptoms = symptomDao.list();

        return jsonUtil.toJson(symptoms);
    }
}
