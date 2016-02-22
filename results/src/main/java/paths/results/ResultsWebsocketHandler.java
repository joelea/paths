package paths.results;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.List;

import static com.google.common.base.Throwables.propagate;

@WebSocket
public class ResultsWebsocketHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        ResultsEndpoint.sessions.add(session);
        send(session, ResultsEndpoint.results.getAll());
    }

    static void broadcast(List<Result> results) {
        ResultsEndpoint.sessions.forEach(session -> send(session, results));
    }

    public static void send(Session session, List<Result> message) {
        try {
            session.getRemote().sendString(OBJECT_MAPPER.writeValueAsString(message));
        } catch (IOException e) {
            throw propagate(e);
        }
    }

    @OnWebSocketClose
    public void onClose(Session session, int something, String somethingElse) {
        ResultsEndpoint.sessions.remove(session);
    }
}
