package main.java.info.highresfelix.forum;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * created by @highresfelix on 9/18/19
 */

public class Main {
    static HashMap<String, User> users = new HashMap<>();
    static ArrayList<Message> messages = new ArrayList<>();

    public static void main(String[] args) {
        addTestUsers();
        addTestMessages();

        Spark.init(); // http://localhost:4567

        Spark.get(
                "/",
                ((request, response) -> {
                    String replyId = request.queryParams("replyId");
                    int replyIdNum = -1;
                    if (replyId != null) {
                        replyIdNum = Integer.parseInt(replyId);
                    }

                    HashMap hashMap = new HashMap();
                    ArrayList<Message> threads = new ArrayList<>();

                    for (Message message: messages) {
                        if (message.replyId == replyIdNum) {
                            threads.add(message);
                        }
                    }

                    Session session = request.session();
                    String userName = session.attribute("userName");

                    hashMap.put("messages", threads);
                    hashMap.put("userName", userName);
                    hashMap.put("replyId", replyIdNum);
                    return new ModelAndView(hashMap, "home.html");
                }),
                new MustacheTemplateEngine()
        );

        // TODO make a post
        Spark.post(
                "/create-message",
                ((request, response) -> {
                    Session session = request.session();
                    String userName = session.attribute("userName");
                    if (userName == null) {
                        throw new Exception("User not logged in.");
                    }

                    String text = request.queryParams("messageText");
                    String replyId = request.queryParams("replyId");
                    if (text == null || replyId == null) {
                        throw new Exception("Didn't get necessary query parameters.");
                    }
                    int replyIdNum = Integer.parseInt(replyId);

                    Message message = new Message(messages.size(), replyIdNum, userName, text);
                    messages.add(message);

                    response.redirect(request.headers("Referer")); // redirect to the referrer URL
                    return "";
                })
        );

        Spark.post(
                "/login",
                ((request, response) -> {
                    String userName = request.queryParams("loginName");
                    if (userName == null) {
                        throw new Exception("Login name not found.");
                    }

                    User user = users.get(userName);
                    if (user == null) {
                        user = new User(userName);
                        users.put(userName, user);
                    }

                    Session session = request.session();
                    session.attribute("userName", userName);

                    response.redirect("/"); // redirect to top lvl
                    return "";
                })
        );

        Spark.post(
                "/logout",
                ((request, response) -> {
                    Session session = request.session();
                    session.invalidate();
                    response.redirect("/");
                    return "";
                })
        );
    }

    private static void addTestUsers() {
        users.put("Alice", new User("Alice"));
        users.put("Bob", new User("Bob"));
        users.put("Charlie", new User("Charlie"));
    }

    private static void addTestMessages() {
        messages.add(new Message(0, -1, "Alice", "Hello World!"));
        messages.add(new Message(1, -1, "Bob", "This is another thread!"));
        messages.add(new Message(2, 0, "Charlie", "Cool thread, Alice."));
        messages.add(new Message(3, 2, "Alice", "Thanks"));
    }
}
