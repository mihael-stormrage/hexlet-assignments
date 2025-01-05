package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
public final class PostsPage {
    @Getter
    private final List<Post> posts;

    @Getter
    private final int pageNumber;

    private final boolean hasPrev;
    private final boolean hasNext;

    public boolean hasPrev() {
        return this.hasPrev;
    }

    public boolean hasNext() {
        return this.hasNext;
    }
}
// END


