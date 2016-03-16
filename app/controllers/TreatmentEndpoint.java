package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.treatments.TreatmentIBDServiceFacade;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class TreatmentEndpoint extends Controller
{
    private static final Logger.ALogger logger = Logger.of(TreatmentEndpoint.class);

    private TreatmentIBDServiceFacade facade;

    @Inject public TreatmentEndpoint(TreatmentIBDServiceFacade facade)
    {
        this.facade = facade;
    }

    @Transactional
    public Result listTreatments()
    {
        JsonNode jsonResponse = facade.list();

        return ok(jsonResponse);
    }

    @Transactional public Result findTreatment(Long id)
    {
        JsonNode jsonResponse = facade.find(retrieveID(id));

        return ok(jsonResponse);
    }

    @Transactional public Result createTreatment()
    {
        JsonNode jsonResponse = facade.create(request().body().asJson());

        return ok(jsonResponse);
    }

    @Transactional public Result updateTreatment()
    {
        JsonNode jsonResponse = facade.update(request().body().asJson());

        return ok(jsonResponse);
    }

    @Transactional public Result deleteTreatment(Long id)
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
