package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    private static final Exception INVALID_LOGIN = new Exception("Wrong username or password");

    public static void build(Context ctx) {
        LoginPage page = new LoginPage("", null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String password = encrypt(ctx.formParam("password"));
        try {
            var user = UsersRepository.findByName(name)
                .orElseThrow(() -> INVALID_LOGIN);
            if (!user.getPassword().equals(password)) {
                throw INVALID_LOGIN;
            }

            ctx.sessionAttribute("name", name);
            ctx.redirect("/");
        } catch (Exception e) {
            LoginPage page = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }

    public static void index(Context ctx) {
        MainPage page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("index.jte", model("page", page));
    }
    // END
}
