package hw6.users;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> getNamesList(List<UserElement> users) {
        List<String> names = new ArrayList<>();

        for (UserElement user : users) {
            names.add(user.getUser());
        }

        return names;
    }

    public static List<String> getIDsList(List<UserElement> users) {
        List<String> IDs = new ArrayList<>();

        for (UserElement user : users) {
            IDs.add(user.getNumber());
        }

        return IDs;
    }

    public static List<String> getDescriptionsList(List<UserElement> users) {
        List<String> descs = new ArrayList<>();

        for (UserElement user : users) {
            descs.add(user.getDescription());
        }

        return descs;
    }
}
