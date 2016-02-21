package paths.results;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.List;

@WebSocket
public class ResultsWebsocketHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Result RESULT = ImmutableResult.builder()
            .pupil("Joe")
            .score(90)
            .build();
    private static final List<Result> MESSAGE = ImmutableList.of(RESULT);

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        ResultsEndpoint.sessions.add(session);
        session.getRemote().sendString(OBJECT_MAPPER.writeValueAsString(MESSAGE));
    }

    @OnWebSocketClose
    public void onClose(Session session, int something, String somethingElse) {
        ResultsEndpoint.sessions.remove(session);
    }
}
