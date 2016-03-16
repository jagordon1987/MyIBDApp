package service.treatments;

import com.fasterxml.jackson.databind.JsonNode;
import service.IBDService;
import service.ServiceNotAvailable;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class TreatmentIBDServiceFacade extends IBDService
{
    private CreateTreatmentIBDService createTreatmentService;

    private ListTreatmentIBDService listTreatmentService;

    private UpdateTreatmentIBDService updateTreatmentService;

    private DeleteTreatmentIBDService deleteTreatmentService;

    private FindTreatmentIBDService findTreatmentService;

    private JSONUtil jsonUtil;

    @Inject public TreatmentIBDServiceFacade(ServiceNotAvailable unavailableServiceOperation,
                                             CreateTreatmentIBDService createTreatmentService,
                                             ListTreatmentIBDService listTreatmentService,
                                             UpdateTreatmentIBDService updateTreatmentService,
                                             DeleteTreatmentIBDService deleteTreatmentService,
                                             FindTreatmentIBDService findTreatmentService,
                                             JSONUtil jsonUtil)
    {
        super(unavailableServiceOperation);

        this.createTreatmentService = createTreatmentService;

        this.listTreatmentService = listTreatmentService;

        this.updateTreatmentService = updateTreatmentService;

        this.deleteTreatmentService = deleteTreatmentService;

        this.findTreatmentService = findTreatmentService;

        this.jsonUtil = jsonUtil;
    }

    @Override public JsonNode list()
    {
        return listTreatmentService.execute(jsonUtil.toJson(""));
    }

    @Override public JsonNode create(JsonNode jsonResource)
    {
        return createTreatmentService.execute(jsonResource);
    }

    @Override public JsonNode update(JsonNode jsonResource)
    {
        return updateTreatmentService.execute(jsonResource);
    }

    @Override public JsonNode delete(JsonNode identifier)
    {
        return deleteTreatmentService.execute(identifier);
    }

    @Override
    public JsonNode find(JsonNode identifier)
    {
        return findTreatmentService.execute(identifier);
    }
}
