package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import exercise.dto.BasePage;

// BEGIN
@Getter
@AllArgsConstructor
public final class PostsPage extends BasePage {
    List<Post> posts;
}
// END
