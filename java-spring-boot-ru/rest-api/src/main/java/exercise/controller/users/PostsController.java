package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api/users/{userId}/posts")
public class PostsController {
    private final List<Post> posts = Data.getPosts();

    @GetMapping
    public List<Post> index(@PathVariable int userId) {
        return posts.stream()
            .filter(p -> p.getUserId() == userId)
            .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable int userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post);
        return post;
    }
}
// END
