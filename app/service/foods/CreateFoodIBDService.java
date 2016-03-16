package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import persistence.entities.FoodEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;

import javax.inject.Inject;

public class CreateFoodIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateFoodIBDService.class);

    private FoodDao foodDao;

    @Inject
    public CreateFoodIBDService(FoodDao foodDao)
    {
        this.foodDao = foodDao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        FoodEntity food = getFoodEntity(jsonRequest);

        foodDao.create(food);

        return jsonRequest;
    }

    private FoodEntity getFoodEntity(JsonNode jsonRequest)
    {
        FoodEntity food = new FoodEntity();
        food.setName(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_STATUS_NAME).textValue());
        food.setInformation(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_INFORMATION).textValue());
        return food;
    }
}
