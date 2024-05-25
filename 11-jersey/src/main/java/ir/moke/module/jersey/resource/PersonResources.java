package ir.moke.module.jersey.resource;

import ir.moke.module.jersey.InMemoryDB;
import ir.moke.module.jersey.model.Person;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Path("/person")
public class PersonResources {
    private static final Logger logger = LoggerFactory.getLogger(PersonResources.class);

    public PersonResources() {
        InMemoryDB.instance.init();
    }

    @POST
    public Response addPerson(Person person) {
        logger.info("Add new person");
        InMemoryDB.instance.add(person);
        return Response.ok(person).build();
    }

    @PUT
    public Response updatePerson(Person person) {
        logger.info("Update person id {}", person.getId());
        Person dbPerson = InMemoryDB.instance.find(person.getId());
        Optional.ofNullable(person.getName()).ifPresent(dbPerson::setName);
        Optional.ofNullable(person.getFamily()).ifPresent(dbPerson::setFamily);
        InMemoryDB.instance.update(person);
        return Response.ok(person).build();
    }

    @GET
    @Path("{id}")
    public Response getPerson(@PathParam("id") Long id) {
        logger.info("Get person id {}", id);
        return Response.ok(InMemoryDB.instance.find(id)).build();
    }

    @GET
    public Response getAllPersons() {
        logger.info("Get all persons");
        return Response.ok(InMemoryDB.instance.findAll()).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        logger.info("Delete person {}", id);
        Person person = InMemoryDB.instance.find(id);
        if (person != null) InMemoryDB.instance.remove(person);
        return Response.ok().build();
    }
}
