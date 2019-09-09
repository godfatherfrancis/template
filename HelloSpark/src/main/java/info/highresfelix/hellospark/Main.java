package main.java.info.highresfelix.hellospark;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

/**
 * created by @highresfelix on 9/9/19
 */

public class Main {
    static User user;

    // http://localhost:4567
    public static void main(String[] args) {
        Spark.init();

        Spark.get(
                "/",
                ((request, response) -> {
                    HashMap hashMap = new HashMap();
                    if (user == null) {
                        return new ModelAndView(hashMap, "login.html");
                    } else {
                        hashMap.put("name", user.name);
                        return new ModelAndView(hashMap, "home.html");
                    }
                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/login",
                ((request, response) -> {
                    String name = request.queryParams("loginName");
                    user = new User(name);
                    response.redirect("/");
                    return "";
                })
        );
    }
}
