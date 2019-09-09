package main.java.info.highresfelix.microblog;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * created by @highresfelix on 9/9/19
 */

public class Main {
//    static User user;
    static HashMap<String, User> users = new HashMap<>();
    static Message message;
    static HashMap messageMap;
    static ArrayList<Message> messages;

    public static void main(String[] args) {
        Spark.init(); // http://localhost:4567

        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap hashMap = new HashMap();

                    Session session = request.session();
                    String userName = session.attribute("userName");
                    User user = users.get(userName);

                    if (user == null) {
                        System.out.println("user null");
                        return new ModelAndView(hashMap, "index.html");
                    } else {
                        System.out.println(user.name + " messages.html");
                        hashMap.put("name", user.name);
                        return new ModelAndView(hashMap, "messages.html");
                    }
                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/create-user",
                ((request, response) -> {
                    String name = request.queryParams("userName");
                    User user = users.get(name);
                    if (user == null) {
                        user = new User(name);
                        users.put(name, user);
                    }

                    Session session = request.session();
                    session.attribute("userName", name);

                    response.redirect("/");
                    return "";
                })
        );

        // TODO create, save & display message
        Spark.post(
                "/create-message",
                ((request, response) -> {
                    String userMessage = request.queryParams("message");
                    System.out.println(userMessage);
                    message = new Message(userMessage);
                    messages.add(message);
                    messageMap.put("message", messages);
                    response.redirect("/");
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
}
