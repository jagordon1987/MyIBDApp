package service.symptoms;

import com.fasterxml.jackson.databind.JsonNode;
import service.IBDService;
import service.ServiceNotAvailable;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class SymptomIBDServiceFacade extends IBDService
{
    private CreateSymptomIBDService createSymptomService;

    private ListSymptomIBDService listSymptomService;

    private UpdateSymptomIBDService updateSymptomService;

    private DeleteSymptomIBDService deleteSymptomService;

    private FindSymptomIBDService findSymptomService;

    private JSONUtil jsonUtil;

    @Inject public SymptomIBDServiceFacade(ServiceNotAvailable unavailableServiceOperation,
                                           CreateSymptomIBDService createSymptomService,
                                           ListSymptomIBDService listSymptomService,
                                           UpdateSymptomIBDService updateSymptomService,
                                           DeleteSymptomIBDService deleteSymptomService,
                                           FindSymptomIBDService findSymptomService,
                                           JSONUtil jsonUtil)
    {
        super(unavailableServiceOperation);

        this.createSymptomService = createSymptomService;

        this.listSymptomService = listSymptomService;

        this.updateSymptomService = updateSymptomService;

        this.deleteSymptomService = deleteSymptomService;

        this.findSymptomService = findSymptomService;

        this.jsonUtil = jsonUtil;
    }

    @Override public JsonNode list()
    {
        return listSymptomService.execute(jsonUtil.toJson(""));
    }

    @Override public JsonNode create(JsonNode jsonResource)
    {
        return createSymptomService.execute(jsonResource);
    }

    @Override public JsonNode update(JsonNode jsonResource)
    {
        return updateSymptomService.execute(jsonResource);
    }

    @Override public JsonNode delete(JsonNode identifier)
    {
        return deleteSymptomService.execute(identifier);
    }

    @Override
    public JsonNode find(JsonNode identifier)
    {
        return findSymptomService.execute(identifier);
    }
}
