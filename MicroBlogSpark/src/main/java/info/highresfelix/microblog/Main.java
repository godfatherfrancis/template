package main.java.info.highresfelix.microblog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

/**
 * created by @highresfelix on 9/9/19
 */

public class Main {
    static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        if (users.isEmpty()) {
            try {
                readFromJson();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Spark.init(); // http://localhost:4567

        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap hashMap = new HashMap();

                    Session session = request.session();
                    String userName = session.attribute("userName");
                    User user = users.get(userName);

                    if (user == null) {
                        return new ModelAndView(hashMap, "index.html");
                    } else {
                        return new ModelAndView(user, "messages.html");
                    }
                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/create-user",
                ((request, response) -> {
                    Session session = request.session();

                    String name = request.queryParams("userName");
                    String password = request.queryParams("userPassword");
                    User user = users.get(name);
                    if (user == null) {
                        user = new User(name, password);
                        users.put(name, user);
                        session.attribute("userName", name);
                    } else if (!user.password.equals(password)) {
                        System.out.println("INVALID PASSWORD");
                        session.invalidate();
                    } else {
                        session.attribute("userName", name);
                    }

                    response.redirect("/");
                    writeToJson(user);
                    return "";
                })
        );

        Spark.post(
                "/create-message",
                ((request, response) -> {
                    Session session = request.session();
                    String name = session.attribute("userName");
                    User user = users.get(name);
                    if (user == null) {
                        throw new Exception("User is not logged in");
                    }

                    String userMessage = request.queryParams("message");
                    Message message = new Message(userMessage);

                    user.messages.add(message);

                    response.redirect("/");
                    writeToJson(user);
                    return "";
                })
        );

        Spark.post(
                "/edit-message",
                ((request, response) -> {
                    Session session = request.session();
                    String name = session.attribute("userName");
                    User user = users.get(name);
                    if (user == null) {
                        throw new Exception("User is not logged in");
                    }

                    int messageId = Integer.parseInt(request.queryParams("messageId")) - 1;
                    Message message = user.messages.get(messageId);

                    if (user.messages.contains(message)) {
                        String editMessage = request.queryParams("editMessage");
                        message.message = editMessage;
                    }

                    response.redirect("/");
                    writeToJson(user);
                    return "";
                })
        );

        Spark.post(
                "/delete-message",
                ((request, response) -> {
                    Session session = request.session();
                    String name = session.attribute("userName");
                    User user = users.get(name);
                    if (user == null) {
                        throw new Exception("User is not logged in");
                    }

                    if (!user.messages.isEmpty()) {
                        int messageId = Integer.parseInt(request.queryParams("messageId")) - 1;
                        Message message = user.messages.get(messageId);
                        user.messages.remove(message);
                    }

                    response.redirect("/");
                    writeToJson(user);
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

    private static void writeToJson(User user) throws IOException {
        File file = new File("users.json");

        Gson gson = new Gson();
        String json = gson.toJson(user);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.close();
    }

    private static void readFromJson() throws IOException {
        File file = new File("users.json");
        Scanner scanner = new Scanner(file);

        Gson gson = new Gson();

        Type userListType = new TypeToken<User>(){}.getType();
        User jsonUser = gson.fromJson(scanner.nextLine(), userListType);
        users.put(jsonUser.name, jsonUser);
    }
}
