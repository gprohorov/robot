package pro.websocket.message;

/**
 * Created by george on 28.11.18.
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class Message {
    private  Topic topic;
    private  String data;
    private String content;
    private String sender;

    public Message(Topic topic, String data) {
        this.topic = topic;
        this.data = data;
    }

    public Message() {
    }

    public Message(Topic topic, String data, String content, String sender) {
        this.topic = topic;
        this.data = data;
        this.content = content;
        this.sender = sender;
    }

    @JsonCreator
    public Message(@JsonProperty("topic") Topic topic, @JsonProperty("data") JsonNode data) {
        this.topic = topic;
        this.data = data.toString();
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setData(String data) {
        this.data = data;
    }

    Topic getTopic() {
        return topic;
    }

    String getData() {
        return data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}