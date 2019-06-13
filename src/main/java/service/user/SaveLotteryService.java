package service.user;

import dao.user.SaveLotteryDao;
import model.LotteryBought;

public class SaveLotteryService {
    public static boolean saveLotteryBought(LotteryBought lottery) {
        return SaveLotteryDao.saveLotteryBought(lottery);
    }
}
