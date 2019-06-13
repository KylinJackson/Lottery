package dao;

import model.Action;
import model.Bill;
import model.State;
import util.DBUtil;

import java.sql.*;

public class SaveBillDao {
    public static boolean saveBill(Bill bill) {
        try {
            Connection connection = DBUtil.getConnection();
            assert connection != null;
            String sql = null;
            if (bill.getState() == State.NOT_FINISH) {
                sql = "insert into `lottery`.`bill`(`create_date`, `amount`, `service_charge`, `information`, `state`" +
                        ", `action`, `payerId`, `payeeId`) values (?,?,?,?,?,?,?,?)";
            } else {
                sql = "insert into `lottery`.`bill`(`create_date`, `amount`, `service_charge`, `information`, `state`" +
                        ", `action`, `payerId`, `payeeId`, `finish_date`) values (?,?,?,?,?,?,?,?,?)";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, service.Utils.dateToString(bill.getDateCreated()));
            preparedStatement.setDouble(2, bill.getAmount());
            preparedStatement.setDouble(3, bill.getCharge());
            preparedStatement.setString(4, bill.getInformation());
            preparedStatement.setString(5, stateToString(bill.getState()));
            preparedStatement.setString(6, actionToString(bill.getAction()));
            preparedStatement.setString(7, bill.getPayerId());
            preparedStatement.setString(8, bill.getPayeeId());

            if (bill.getState() == State.FINISH) {
                preparedStatement.setString(9, service.Utils.dateToString(bill.getDateFinished()));
            }
            boolean result = preparedStatement.execute();

            sql = "select `id` from `lottery`.`bill` where `payerId`=? and `payeeId`=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bill.getPayerId());
            preparedStatement.setString(2, bill.getPayeeId());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.last();
            bill.setId(resultSet.getString("id"));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static String stateToString(State state) {
        if (state == State.NOT_FINISH) return "NOT_FINISH";
        else return "FINISH";
    }

    private static String actionToString(Action action) {
        if (action == Action.TOP_UP) return "TOP_UP";
        else return "WITHDRAW";

    }

}