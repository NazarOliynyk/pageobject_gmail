package userdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetData {
    public static void main(String[] args) throws Exception {
        User user1 = User.builder()
                .userId(0).userEmail("testepamivan@gmail.com")
                .userPassword("myprojectmailsende@1").build();
        User user2 = User.builder()
                .userId(1).userEmail("testepampetro@gmail.com")
                .userPassword("myprojectmailsende@2").build();
        User user3 = User.builder()
                .userId(2).userEmail("test1pavlo@gmail.com")
                .userPassword("myprojectmailsende@3").build();
        User user4 = User.builder()
                .userId(3).userEmail("dimamalash5@gmail.com")
                .userPassword("myprojectmailsende@4").build();
        User user5 = User.builder()
                .userId(4).userEmail("gavruloepam@gmail.com")
                .userPassword("myprojectmailsende@5").build();

        List<User> userList = new ArrayList<>();
        Collections.addAll(userList, user1, user2, user3, user4, user5);

        UserDAO userDAO = new UserDAO();
        userDAO.saveAll(userList);
    }
}
