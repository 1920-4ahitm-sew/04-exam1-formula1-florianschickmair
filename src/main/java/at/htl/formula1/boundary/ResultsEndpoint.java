package at.htl.formula1.boundary;

import at.htl.formula1.entity.Driver;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


public class ResultsEndpoint {


    /**
     * @param name als QueryParam einzulesen
     * @return JsonObject
     */
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPointsSumOfDriver(@NamedQuery("NAME") String name) {

        TypedQuery<Driver> query = em.createNamedQuery("Driver.findByName",Driver.class)
                .setParameter("NAME",name);

        //return Response .ok()



        return null;
    }

    /**
     * @param id des Rennens
     * @return
     */

    @GET
    public Response findWinnerOfRace(long id) {
        return null;
    }







}
