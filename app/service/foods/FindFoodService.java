package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import persistence.entities.FoodEntity;
import play.Logger;
import service.ServiceOperation;
import util.constants.IBDConstants;
import util.util.json.play.JSONHelper;

import javax.inject.Inject;

public class FindFoodService extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(FindFoodService.class);

    private FoodDao foodDao;

    private JSONHelper jsonHelper;

    @Inject
    public FindFoodService(FoodDao foodDao, JSONHelper jsonHelper)
    {
        this.foodDao = foodDao;
        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDConstants.FOOD_JSON_ID_PROPERTY).textValue());

        FoodEntity food = foodDao.find(id);

        return jsonHelper.toJson(food);
    }
}
