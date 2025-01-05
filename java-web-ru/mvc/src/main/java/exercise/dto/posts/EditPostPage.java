package exercise.dto.posts;

import java.util.List;
import java.util.Map;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
import lombok.RequiredArgsConstructor;
import exercise.model.Post;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public final class EditPostPage {
    private final Post post;
    private Map<String, List<ValidationError<Object>>> errors;
}
// END
