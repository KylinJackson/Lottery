package service.user;

import dao.user.LoginDao;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    public static boolean checkLogin(User user) {
        ResultSet resultSet = LoginDao.checkLogin(user);
        try {
            assert resultSet != null;
            int rowCount = 0;
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                user.setId(id);
                rowCount++;
            }
            return rowCount == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
