package pro.websocket;

/**
 * Created by george on 15.11.18.
 */

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import pro.websocket.EventHandler;

import java.io.IOException;

public class EventRobotClient {
    public static void main(String[] args) {
        // connection url
        String uri = "ws://localhost:8090/robot";

        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketSession session = null;
        try {
            // The socket that receives events
            EventHandler socket = new EventHandler();
            // Make a handshake with server
            ListenableFuture<WebSocketSession> fut = client.doHandshake(socket, uri);
            // Wait for Connect
            session = fut.get();

            // Send a message
            for (int i = 0; i <5 ; i++) {
            session.sendMessage(new TextMessage("Hello"));
            session = fut.get();

        }
            // Close session
          session.close();

        } catch (Throwable t) {
            t.printStackTrace(System.err);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (IOException ignored) {
            }
        }
    }
}