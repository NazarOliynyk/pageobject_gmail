package userdata;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1611867719076851676L;
    private int id;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {

        User user = new User();

        UserBuilder userId(int id) {
            user.id = id;
            return this;
        }

        UserBuilder userEmail(String email) {
            user.email = email;
            return this;
        }

        UserBuilder userPassword(String pass) {
            user.password = pass;
            return this;
        }

        User build() {
            return user;
        }
    }
}
