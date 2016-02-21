package paths.results;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ResultsWebsocketHandler {

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
        ResultsEndpoint.sessions.add(session);
    }

    @OnWebSocketClose
    public void onClose(Session session, int something, String somethingElse) {
        ResultsEndpoint.sessions.remove(session);
    }
}
