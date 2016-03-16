package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import service.Service;
import service.UnavailableServiceOperation;
import util.util.json.play.JSONHelper;

import javax.inject.Inject;

public class FoodServiceFacade extends Service
{
    private CreateFoodService createFoodService;

    private ListFoodService listFoodService;

    private UpdateFoodService updateFoodService;

    private DeleteFoodService deleteFoodService;

    private FindFoodService findFoodService;

    private JSONHelper jsonHelper;

    @Inject public FoodServiceFacade(UnavailableServiceOperation unavailableServiceOperation,
                                     CreateFoodService createFoodService,
                                     ListFoodService listFoodService,
                                     UpdateFoodService updateFoodService,
                                     DeleteFoodService deleteFoodService,
                                     FindFoodService findFoodService,
                                     JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.createFoodService = createFoodService;

        this.listFoodService = listFoodService;

        this.updateFoodService = updateFoodService;

        this.deleteFoodService = deleteFoodService;

        this.findFoodService = findFoodService;

        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listFoodService.execute(jsonHelper.toJson(""));
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
