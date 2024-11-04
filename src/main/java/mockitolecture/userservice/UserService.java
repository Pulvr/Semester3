package mockitolecture.userservice;

public class UserService {

    private User storedUser;

    void storeUser(User user) {
        if (user != null) {
            storedUser = user;
            System.out.println("Stored user" + user.name());
        }
    }

    User getStoredUser() {
        return storedUser;
    }
}
