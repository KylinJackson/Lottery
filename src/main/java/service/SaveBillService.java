package service;

import dao.SaveBillDao;
import model.Bill;

public class SaveBillService {
    public static boolean saveBill(Bill bill) {
        return SaveBillDao.saveBill(bill);
    }

}
