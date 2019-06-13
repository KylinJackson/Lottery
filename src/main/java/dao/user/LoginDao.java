package dao.user;

import model.User;
import util.DBUtil;

import java.sql.*;

public class LoginDao {
    public static ResultSet checkLogin(User user) {
        try {
            Connection connection = DBUtil.getConnection();
            assert connection != null;
            String sql = "select * from `lottery`.`user` where `username`=? and `password`=password(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
