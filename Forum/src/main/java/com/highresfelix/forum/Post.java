package main.java.com.highresfelix.forum;

/**
 * created by @highresfelix on 9/3/19
 */

public class Post {
    int replyId;
    String author;
    String text;

    public Post(int replyId, String author, String text) {
        this.replyId = replyId;
        this.author = author;
        this.text = text;
    }
}
