package userdata;

import java.util.ArrayList;
import java.util.List;

public class SetData {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setId(1);
        user.setEmail("testepamivan@gmail.com");
        user.setPassword("myprojectmailsende@1");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        UserDAO userDAO = new UserDAO();
        userDAO.saveAll(userList);
    }
}
