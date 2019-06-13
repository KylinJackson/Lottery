package model;

import java.util.Date;

public class LotteryResult extends Numbers {
    private String id = null;
    private String phase = null;
    private Date date = null;

    public LotteryResult() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
