package Models.User;

public interface UserInterface {
    User logIn(String email, String password);
    int register(User user);
    User updateUser(User user);
    int deleteUser(User user);
    User getUserById(String id);
    User[] getAllUser();
}
