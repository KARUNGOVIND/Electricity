package electricity;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    private Map<Integer, User> usersById = new HashMap<>();

    public void registerUser(User user) {
        usersById.put(user.getUserId(), user);
    }

    public User getUserById(int userId) {
        return usersById.get(userId);
    }

    public boolean validateUser(String name, String password) {
        for (User user : usersById.values()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByNameAndPassword(String name, String password) {
        for (User user : usersById.values()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // New updateUser method
    public void updateUser(int userId, String name, String phoneNumber, String email, String electricityBoardNo) {
        User user = usersById.get(userId);
        if (user != null) {
            user.setName(name);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            user.setElectricityBoardNo(electricityBoardNo);
        }
    }
}
