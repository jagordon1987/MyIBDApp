package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import persistence.entities.FoodEntity;
import play.Logger;
import service.ServiceOperation;
import util.util.json.play.JSONHelper;

import javax.inject.Inject;
import java.util.List;

public class ListFoodService extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListFoodService.class);

    private FoodDao foodDao;

    private JSONHelper jsonHelper;

    @Inject
    public ListFoodService(FoodDao foodDao, JSONHelper jsonHelper)
    {
        this.foodDao = foodDao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<FoodEntity> foods = foodDao.list();

        return jsonHelper.toJson(foods);
    }
}
