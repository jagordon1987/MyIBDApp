package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.symptoms.SymptomIBDServiceFacade;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class SymptomEndpoint extends Controller
{
    private static final Logger.ALogger logger = Logger.of(SymptomEndpoint.class);

    private SymptomIBDServiceFacade facade;

    @Inject public SymptomEndpoint(SymptomIBDServiceFacade facade)
    {
        this.facade = facade;
    }

    @Transactional
    public Result listSymptoms()
    {
        JsonNode jsonResponse = facade.list();

        return ok(jsonResponse);
    }

    @Transactional public Result findSymptom(Long id)
    {
        JsonNode jsonResponse = facade.find(retrieveID(id));

        return ok(jsonResponse);
    }

    @Transactional public Result createSymptom()
    {
        JsonNode jsonResponse = facade.create(request().body().asJson());

        return ok(jsonResponse);
    }

    @Transactional public Result updateSymptom()
    {
        JsonNode jsonResponse = facade.update(request().body().asJson());

        return ok(jsonResponse);
    }

    @Transactional public Result deleteSymptom(Long id)
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
