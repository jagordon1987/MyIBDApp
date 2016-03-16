package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import service.IBDService;
import service.ServiceNotAvailable;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class FoodIBDServiceFacade extends IBDService
{
    private CreateFoodIBDService createFoodService;

    private ListFoodIBDService listFoodService;

    private UpdateFoodIBDService updateFoodService;

    private DeleteFoodIBDService deleteFoodService;

    private FindFoodIBDService findFoodService;

    private JSONUtil jsonUtil;

    @Inject public FoodIBDServiceFacade(ServiceNotAvailable unavailableServiceOperation,
                                        CreateFoodIBDService createFoodService,
                                        ListFoodIBDService listFoodService,
                                        UpdateFoodIBDService updateFoodService,
                                        DeleteFoodIBDService deleteFoodService,
                                        FindFoodIBDService findFoodService,
                                        JSONUtil jsonUtil)
    {
        super(unavailableServiceOperation);

        this.createFoodService = createFoodService;

        this.listFoodService = listFoodService;

        this.updateFoodService = updateFoodService;

        this.deleteFoodService = deleteFoodService;

        this.findFoodService = findFoodService;

        this.jsonUtil = jsonUtil;
    }

    @Override public JsonNode list()
    {
        return listFoodService.execute(jsonUtil.toJson(""));
    }

    @Override public JsonNode create(JsonNode jsonResource)
    {
        return createFoodService.execute(jsonResource);
    }

    @Override public JsonNode update(JsonNode jsonResource)
    {
        return updateFoodService.execute(jsonResource);
    }

    @Override public JsonNode delete(JsonNode identifier)
    {
        return deleteFoodService.execute(identifier);
    }

    @Override
    public JsonNode find(JsonNode identifier)
    {
        return findFoodService.execute(identifier);
    }
}
