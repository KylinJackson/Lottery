package dao;

import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {
    public static void searchUserById(User user) {
        String sql = "select `username` from `lottery`.`user` where `id`=?";
        Connection connection = DBUtil.getConnection();
        assert connection != null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
            user.setName(resultSet.getString("username"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
