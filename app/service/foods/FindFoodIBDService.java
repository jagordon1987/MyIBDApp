package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import persistence.entities.FoodEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class FindFoodIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(FindFoodIBDService.class);

    private FoodDao foodDao;

    private JSONUtil jsonUtil;

    @Inject
    public FindFoodIBDService(FoodDao foodDao, JSONUtil jsonUtil)
    {
        this.foodDao = foodDao;
        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_ID_PROPERTY).textValue());

        FoodEntity food = foodDao.find(id);

        return jsonUtil.toJson(food);
    }
}
