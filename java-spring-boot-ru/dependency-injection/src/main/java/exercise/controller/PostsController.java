package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private static ResourceNotFoundException notFount(long id) {
        return new ResourceNotFoundException(
            String.format("Post with id %s not found", id)
        );
    }

    @GetMapping
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post show(@PathVariable long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> notFount(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable long id, @RequestBody Post post) {
        if (!postRepository.existsById(id)) {
            throw notFount(id);
        }
        post.setId(id);
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if (!postRepository.existsById(id)) {
            throw notFount(id);
        }
        postRepository.deleteById(id);
        commentRepository.deleteByPostId(id);
    }
}
// END
