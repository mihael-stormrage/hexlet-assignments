package exercise.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import exercise.dto.BasePage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildPostPage extends BasePage {
    private String name;
    private String body;
}
