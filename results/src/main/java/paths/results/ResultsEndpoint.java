package paths.results;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static spark.Spark.init;
import static spark.Spark.post;
import static spark.Spark.webSocket;

public class ResultsEndpoint {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final List<Session> sessions = new ArrayList<>();
    public static final Results results = Results.createDefault();
    private static List<Result> previous;

    public static void main(String[] args) throws InterruptedException {

        webSocket("/all", ResultsWebsocketHandler.class);
        init();

        post("/add", ResultsEndpoint::addResult);

        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(
                ResultsEndpoint::checkDb,
                0,
                10,
                MILLISECONDS
        );
    }

    private static void checkDb() {
        List<Result> current = results.getAll();

        if(!current.equals(previous)) {
            ResultsWebsocketHandler.broadcast(current);
        }

        previous = current;
    }

    private static boolean addResult(Request request, Response response) throws IOException {
        Result resultToBeAdded = OBJECT_MAPPER.readValue(request.body(), Result.class);
        results.add(resultToBeAdded);
        return true;
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
