package Models.User;

import java.util.List;
import java.util.Map;

public interface UserInterface {
    User logIn(String email, String password);
    User register(User user);
    User updateUser(User user);
    int deleteUser(User user);
    User getUserById(String id);
    List<User> getAllUser();
}
