package model;

import java.util.Date;

public class LotteryBought extends Numbers {
    private String id = null;
    private String phase = null;
    private Double amount = null;
    private Date datetime = null;
    private Price isPrice = null;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    private String buyerId = null;

    public LotteryBought() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Price isPrice() {
        return isPrice;
    }

    public void setPrice(Price price) {
        isPrice = price;
    }

}


