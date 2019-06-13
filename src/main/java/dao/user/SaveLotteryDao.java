package dao.user;

import model.LotteryBought;
import model.Price;
import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;

public class SaveLotteryDao {
    public static boolean saveLotteryBought(LotteryBought lottery) {
        try {
            Connection connection = DBUtil.getConnection();
            assert connection != null;
            String sql = "insert into lottery.lottery_bought(`red1`, `red2`, `red3`, `red4`, `red5`, `red6`, `blue`," +
                    " `phase`, `date`, `amount`, `isPrice`, `userId`) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lottery.getRed1());
            preparedStatement.setString(2, lottery.getRed2());
            preparedStatement.setString(3, lottery.getRed3());
            preparedStatement.setString(4, lottery.getRed4());
            preparedStatement.setString(5, lottery.getRed5());
            preparedStatement.setString(6, lottery.getRed6());
            preparedStatement.setString(7, lottery.getBlue());
            preparedStatement.setString(8, lottery.getPhase());
            preparedStatement.setString(9, service.Utils.dateToString(lottery.getDatetime()));
            preparedStatement.setDouble(10, lottery.getAmount());
            if (lottery.isPrice() == Price.UNKNOWN) {
                preparedStatement.setString(11, "UNKNOWN");
            } else if (lottery.isPrice() == Price.FALSE) {
                preparedStatement.setString(11, "FALSE");
            } else {
                preparedStatement.setString(11, "TRUE");
            }
            preparedStatement.setString(12, lottery.getBuyerId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
