package pro.websocket;

/**
 * Created by george on 15.11.18.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EventServer {
    public static void main(String[] args) {
        SpringApplication.run(EventServer.class, args);
    }
}