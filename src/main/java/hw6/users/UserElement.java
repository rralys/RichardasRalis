package hw6.users;

public class UserElement {
    private String number;
    private String user;
    private String description;

    public String toString() {
        return number.concat(user).concat(description);
    }

    public String getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

}
