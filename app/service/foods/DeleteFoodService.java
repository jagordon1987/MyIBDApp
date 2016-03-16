package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import play.Logger;
import service.ServiceOperation;
import util.constants.IBDConstants;
import util.util.json.play.JSONHelper;

import javax.inject.Inject;

public class DeleteFoodService extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(DeleteFoodService.class);

    private FoodDao foodDao;

    private JSONHelper jsonHelper;

    @Inject
    public DeleteFoodService(FoodDao foodDao, JSONHelper jsonHelper)
    {
        this.foodDao = foodDao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(IBDConstants.FOOD_JSON_ID_PROPERTY).textValue());

        foodDao.delete(id);

        return jsonHelper.toJson("{\"message\":\"Deleted Food item with the following id" + id + "\"}");
    }
}
