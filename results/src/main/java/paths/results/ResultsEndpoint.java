package paths.results;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import paths.db.Results;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static spark.Spark.init;
import static spark.Spark.webSocket;

public class ResultsEndpoint {
    private static final String TOPIC = "paths.results";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final List<Session> sessions = new ArrayList<>();
    public static Results results = Results.createDefault();

    public static void main(String[] args) throws InterruptedException {
        Events events = new Events(TOPIC);

        webSocket("/results", ResultsWebsocketHandler.class);

        init();
    }

    private static void broadcast(Object value, Predicate<Session> sessionPredicate) {
        try {
            final String message = OBJECT_MAPPER.writeValueAsString(value);
            sessions.stream().filter(sessionPredicate).forEach(session -> {
                try {
                    session.getRemote().sendString(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
