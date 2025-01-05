package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Page not found"));
        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class)
            .getOrDefault(1);
        int pageSize = ctx.queryParamAsClass("take", Integer.class)
            .getOrDefault(5);

        var posts = PostRepository.findAll(pageNumber, pageSize);

        boolean hasPrev = pageNumber > 1;
        boolean hasNext = PostRepository.getEntities().size()
            > (pageNumber - 1) * pageSize + posts.size();

        PostsPage page = new PostsPage(posts, pageNumber, hasPrev, hasNext);
        ctx.render("posts/index.jte", model("page", page));
    }
    // END
}
