package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@Getter
@AllArgsConstructor
public final class UserPage {
    private User user;
}
// END
