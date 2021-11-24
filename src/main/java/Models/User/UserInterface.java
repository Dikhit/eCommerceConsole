package Models.User;

import java.util.List;
import java.util.Map;

public interface UserInterface {
    User logIn(String email, String password);
    int register(User user);
    int updateUser(User user);
    int deleteUser(User user);
    User getUserById(String id);
    List<User> getAllUser();
}
