package ir.moke.module.jersey.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @GET
    public String hello() {
        System.out.println("Hello");
        return "Hello";
    }
}
