package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import static exercise.dto.BasePage.FlashType;
import exercise.dto.BasePage;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    private static void addFlash(Context ctx, BasePage page) {
        String flash = ctx.consumeSessionAttribute("flash");
        var flashType = (FlashType) ctx.consumeSessionAttribute("flashType");
        page.setFlash(flash, flashType);
    }

    public static void create(Context ctx) {
        try {
            String body = ctx.formParam("body").trim();
            String name = ctx.formParamAsClass("name", String.class)
                .check(
                    v -> v.trim().length() >= 2,
                    "Название должно быть не короче 2 символов"
                ).get().trim();

            Post post = new Post(name, body);
            PostRepository.save(post);

            ctx.sessionAttribute("flash", "Post was successfully created!");
            ctx.sessionAttribute("flashType", FlashType.success);
            ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            String msg = e.getErrors().entrySet().stream()
                .findAny().get()
                .getValue()
                .getFirst()
                .getMessage();
            ctx.sessionAttribute("flash", msg);
            ctx.sessionAttribute("flashType", FlashType.danger);

            String name = ctx.formParam("name").trim();
            String body = ctx.formParam("body").trim();
            BuildPostPage page = new BuildPostPage(name, body);
            addFlash(ctx, page);
            ctx.render("posts/build.jte", model("page", page));
        }
    }

    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        PostsPage page = new PostsPage(posts);
        addFlash(ctx, page);
        ctx.render("posts/index.jte", model("page", page));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
