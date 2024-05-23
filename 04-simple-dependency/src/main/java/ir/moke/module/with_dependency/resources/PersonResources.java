package ir.moke.module.with_dependency.resources;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ir.moke.module.common.JsonUtils;
import ir.moke.module.with_dependency.model.Person;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PersonResources implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Person person = new Person("Stephan", "Morphy");
        String json = JsonUtils.toJson(person);
        sendResponse(exchange, json);
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.getResponseHeaders().add("Content-Type","application/json");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(response.getBytes(StandardCharsets.UTF_8));
        responseBody.flush();
        responseBody.flush();
        responseBody.close();
    }
}
