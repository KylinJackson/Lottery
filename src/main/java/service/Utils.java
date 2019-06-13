package service;

import model.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String getPhase() {
        return "0000";
    }

    public static String getUsername(String userId) {
        User user = new User();
        user.setId(userId);
        dao.Utils.searchUserById(user);
        return user.getName();
    }

    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}