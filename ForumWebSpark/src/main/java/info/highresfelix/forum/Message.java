package main.java.info.highresfelix.forum;

/**
 * created by @highresfelix on 9/18/19
 */

public class Message {
    int id;
    int replyId;
    String author;
    String text;

    public Message(int id, int replyId, String author, String text) {
        this.id = id;;
        this.replyId = replyId;
        this.author = author;
        this.text = text;
    }
}
