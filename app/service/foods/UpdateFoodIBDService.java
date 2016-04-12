package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import persistence.entities.FoodEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;

import javax.inject.Inject;

public class UpdateFoodIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(UpdateFoodIBDService.class);

    private FoodDao foodDao;

    @Inject
    public UpdateFoodIBDService(FoodDao foodDao)
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
        Long id = Long.parseLong(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_ID_PROPERTY).textValue());

        FoodEntity food = foodDao.find(id);

        food.setName(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_STATUS_NAME).textValue());
        food.setGroup(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_STATUS_FOOD_GROUP).textValue());
        food.setSeverity(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_STATUS_SEVERITY).textValue());
        food.setInformation(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_INFORMATION).textValue());

        return food;
    }
}
