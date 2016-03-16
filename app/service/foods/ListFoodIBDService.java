package service.foods;

import com.fasterxml.jackson.databind.JsonNode;
import persistence.dao.impl.FoodDao;
import persistence.entities.FoodEntity;
import play.Logger;
import service.IBDServiceOperation;
import util.util.json.play.JSONUtil;

import javax.inject.Inject;
import java.util.List;

public class ListFoodIBDService extends IBDServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListFoodIBDService.class);

    private FoodDao foodDao;

    private JSONUtil jsonUtil;

    @Inject
    public ListFoodIBDService(FoodDao foodDao, JSONUtil jsonUtil)
    {
        this.foodDao = foodDao;

        this.jsonUtil = jsonUtil;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<FoodEntity> foods = foodDao.list();

        return jsonUtil.toJson(foods);
    }
}
