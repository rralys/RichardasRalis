package hw6.users;

import java.util.ArrayList;
import java.util.List;

public class UserElementList {
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
