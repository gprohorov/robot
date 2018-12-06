package pro.websocket;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by george on 15.11.18.
 */

public class EventClient {
    public static void main(String[] args) {

        // connection url
        String uri = "ws://localhost:8181/";//"ws://localhost:8090/events";//"ws://localhost:8181/"

        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketSession session = null;
        try {
            EventHandler socket = new EventHandler();
            // Make a handshake with server
            ListenableFuture<WebSocketSession> fut = client.doHandshake(socket, uri);
            // Wait for Connect
            session = fut.get();
            while(session.isOpen())
            {
                Thread.sleep(2000);
                session.sendMessage(new TextMessage("go 003l039;;-1"));//go 003l039;CCW;-1
                Thread.sleep(7000);
                session.sendMessage(new TextMessage("STOP;;-1"));
            }
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
            } catch (IOException ignored) { }
        }
//        try {
//            // The socket that receives events
//            EventHandler socket = new EventHandler();
//            // Make a handshake with server
//            ListenableFuture<WebSocketSession> fut = client.doHandshake(socket, uri);
//            // Wait for Connect
//            session = fut.get();
//
//            // Send a message
//            for (int i = 0; i < 10; i++) {
//                try
//                {
//                    session.sendMessage(new TextMessage("Hello"));
//                    Thread.sleep(1000);
//                }
//                catch(InterruptedException ex)
//                {
//                    Thread.currentThread().interrupt();
//                }
//            }
//            session.sendMessage(new TextMessage("Hello"));
//            // Close session
//            session.close();
//
//        } catch (Throwable t) {
//            t.printStackTrace(System.err);
//        } finally {
//            try {
//                if (session != null) {
//                    session.close();
//                }
//            } catch (IOException ignored) {
//            }
//        }
    }
}