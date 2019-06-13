package service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import model.Bill;
import model.State;

import java.io.*;

public class BillPDF {
    public static void createPDF(Bill bill, String rootPath) {
        String pathOut = rootPath + "file/pdf/";
        String titleFontPath = rootPath + "font/simhei.ttf";
        String bodyFontPath = rootPath + "font/simhei.ttf";

        Font font_title = null;
        Font font_body = null;

        try {
            BaseFont baseFont_title = BaseFont.createFont(titleFontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            BaseFont baseFont_body = BaseFont.createFont(bodyFontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            font_title = new Font(baseFont_title, 32);
            font_body = new Font(baseFont_body, 12);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pathOut + String.format("%s.pdf", bill.getId())));
            document.open();
            assert font_body != null;
            Paragraph title = new Paragraph("账单", font_title);
            title.setAlignment(1);
            Paragraph empty = new Paragraph(" ", font_title);
            Paragraph body = new Paragraph("", font_body);

            body.add(new Chunk(String.format("账单编号：%s\n", bill.getId())));
            body.add(new Chunk(String.format("付款人：%s\n", Utils.getUsername(bill.getPayerId()))));
            body.add(new Chunk(String.format("收款人：%s\n", Utils.getUsername(bill.getPayeeId()))));
            body.add(new Chunk(String.format("生成时间：%s\n", Utils.dateToString(bill.getDateCreated()))));
            body.add(new Chunk(String.format("金额：%.2f\n", bill.getAmount())));
            body.add(new Chunk(String.format("手续费：%.2f\n", bill.getCharge())));
            body.add(new Chunk(String.format("交易是否完成：%s\n", bill.getState() == State.NOT_FINISH ? "未完成" : "完成")));

            if (bill.getState() == State.FINISH) {
                body.add(new Chunk(String.format("完成时间：%s\n", bill.getDateFinished())));
            }
            body.add(new Chunk(String.format("详细信息：%s\n", bill.getInformation())));
            document.add(title);
            document.add(empty);
            document.add(body);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

