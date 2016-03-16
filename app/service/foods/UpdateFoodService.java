package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import persistence.entities.FoodEntity;
import play.Logger;
import service.ServiceOperation;
import util.constants.IBDConstants;

import javax.inject.Inject;

public class UpdateFoodService extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(UpdateFoodService.class);

    private FoodDao foodDao;

    @Inject
    public UpdateFoodService(FoodDao foodDao)
    {
        this.foodDao = foodDao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        FoodEntity food = getFoodEntity(jsonRequest);

        foodDao.update(food);

        return jsonRequest;
    }

    private FoodEntity getFoodEntity(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDConstants.FOOD_JSON_ID_PROPERTY).textValue());

        FoodEntity food = foodDao.find(id);

        food.setName(jsonRequest.findPath(IBDConstants.FOOD_JSON_STATUS_NAME).textValue());

        food.setInformation(jsonRequest.findPath(IBDConstants.FOOD_JSON_INFORMATION).textValue());

        return food;
    }
}
