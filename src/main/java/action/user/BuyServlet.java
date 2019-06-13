package action.user;

import model.*;
import service.BillPDF;
import service.SaveBillService;
import service.user.SaveLotteryService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String red1 = request.getParameter("red1");
        String red2 = request.getParameter("red2");
        String red3 = request.getParameter("red3");
        String red4 = request.getParameter("red4");
        String red5 = request.getParameter("red5");
        String red6 = request.getParameter("red6");
        String blue = request.getParameter("blue");
        String amountString = request.getParameter("amount");


        ServletContext servletContext = this.getServletContext();
        User user = (User) servletContext.getAttribute("user");
        String phase = (String) servletContext.getAttribute("phase");


        double amount = Double.parseDouble(amountString);
        Date date = new Date();
        LotteryBought lottery = new LotteryBought();
        lottery.setRed1(red1);
        lottery.setRed2(red2);
        lottery.setRed3(red3);
        lottery.setRed4(red4);
        lottery.setRed5(red5);
        lottery.setRed6(red6);
        lottery.setBlue(blue);

        lottery.setPhase(phase);
        lottery.setAmount(amount);
        lottery.setDatetime(date);
        lottery.setPrice(Price.UNKNOWN);
        lottery.setBuyerId(user.getId());

        boolean saveLotteryResult = SaveLotteryService.saveLotteryBought(lottery);

        Bill bill = new Bill();
        bill.setAction(Action.TOP_UP);
        bill.setDateCreated(lottery.getDatetime());
        bill.setAmount(lottery.getAmount());
        bill.setInformation("购买彩票");
        bill.setState(State.NOT_FINISH);
        bill.setCharge(0.0);
        bill.setPayerId(user.getId());
        bill.setPayeeId("2");

        boolean saveBillResult = SaveBillService.saveBill(bill);

        assert saveBillResult && saveLotteryResult;

        BillPDF.createPDF(bill, (String) servletContext.getAttribute("rootPath"));

        session.setAttribute("billId", bill.getId());
        session.setAttribute("payerName", service.Utils.getUsername(bill.getPayerId()));
        session.setAttribute("payeeName", service.Utils.getUsername(bill.getPayeeId()));
        session.setAttribute("createTime", service.Utils.dateToString(bill.getDateCreated()));
        session.setAttribute("amount", String.format("%.2f", bill.getAmount()));
        session.setAttribute("charge", String.format("%.2f", bill.getCharge()));
        if (bill.getState() == State.NOT_FINISH) {
            session.setAttribute("isFinish", "false");
        } else {
            session.setAttribute("isFinish", "true");
            session.setAttribute("finishDate", service.Utils.dateToString(bill.getDateFinished()));
        }
        session.setAttribute("information", bill.getInformation());
        response.sendRedirect("/bill");
    }
}
