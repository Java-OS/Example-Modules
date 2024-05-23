package ir.moke.module.httpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HelloApi implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "Hello";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream responseBody = exchange.getResponseBody();
        responseBody.write(response.getBytes(StandardCharsets.UTF_8));
        responseBody.flush();
        responseBody.flush();
        responseBody.close();
    }
}
