package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.foods.FoodServiceFacade;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class FoodsEndpoint extends Controller
{
    private static final Logger.ALogger logger = Logger.of(FoodsEndpoint.class);

    private FoodServiceFacade facade;

    @Inject public FoodsEndpoint(FoodServiceFacade facade)
    {
        this.facade = facade;
    }

    @Transactional
    public Result listFoods()
    {
        JsonNode jsonResponse = facade.list();

        return ok(jsonResponse);
    }

    @Transactional public Result findFood(Long id)
    {
        JsonNode jsonResponse = facade.find(retrieveID(id));

        return ok(jsonResponse);
    }

    @Transactional public Result createFood()
    {
        JsonNode jsonResponse = facade.create(request().body().asJson());

        return ok(jsonResponse);
    }

    @Transactional public Result updateFood()
    {
        JsonNode jsonResponse = facade.update(request().body().asJson());

        return ok(jsonResponse);
    }

    @Transactional public Result deleteFood(Long id)
    {
        JsonNode jsonResponse = facade.delete(retrieveID(id));

        return ok(jsonResponse);
    }

    protected JsonNode retrieveID(Long id)
    {
        Map<String, String> idMap = new HashMap<>();
        idMap.put("id", id.toString());
        return Json.toJson(idMap);
    }
}
