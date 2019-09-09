package main.java.info.highresfelix.gametracker;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

/**
 * created by @highresfelix on 9/9/19
 */

public class Main {
    static HashMap<String, User> users = new HashMap<>();

    // http://localhost:4567
    public static void main(String[] args) {
        Spark.init();

        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap hashMap = new HashMap();

                    Session session = request.session();
                    String userName = session.attribute("userName");
                    User user = users.get(userName);

                    if (user == null) {
                        return new ModelAndView(hashMap, "login.html");
                    } else {
                        return new ModelAndView(user, "home.html");
                    }
                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/create-game",
                ((request, response) -> {
                    Session session = request.session();
                    String name = session.attribute("userName");
                    User user = users.get(name);
                    if (user == null) {
                        throw new Exception("User is not logged in");
                    }

                    String gameName = request.queryParams("gameName");
                    String gameGenre = request.queryParams("gameGenre");
                    String gamePlatform = request.queryParams("gamePlatform");
                    int gameYear = Integer.valueOf(request.queryParams("gameYear"));
                    Game game = new Game(gameName, gameGenre, gamePlatform, gameYear);

                    user.games.add(game);

                    response.redirect("/");
                    return "";
                })
        );

        Spark.post(
                "/login",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
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
