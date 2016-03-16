package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import play.Logger;
import service.IBDServiceOperation;
import util.constants.IBDApplicationConstants;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;

public class DeleteFoodIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(DeleteFoodIBDService.class);

    private FoodDao foodDao;

    private JSONUtil jsonUtil;

    @Inject
    public DeleteFoodIBDService(FoodDao foodDao, JSONUtil jsonUtil)
    {
        this.foodDao = foodDao;

        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDApplicationConstants.FOOD_JSON_ID_PROPERTY).textValue());

        foodDao.delete(id);

        return jsonUtil.toJson("{\"message\":\"Deleted Food item with the following id" + id + "\"}");
    }
}
