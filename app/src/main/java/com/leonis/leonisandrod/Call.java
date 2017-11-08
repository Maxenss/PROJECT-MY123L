package com.leonis.leonisandrod;

/**
 * Created by Floglor on 08.11.2017.
 */

public class Call {
    static final String MISSED_CALL = "missed";
    static final String RECEIVED_CALL = "received";

    //Null if it was user
    private Contact caller;

    //Null if it was user
    private Contact calee;

    private String duration;
    private String status;
    private String time;

    public Call(Contact caller, String duration, String status, String time) {
        this.caller = caller;
        this.duration = duration;
        this.status = status;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Contact getCaller() {
        return caller;
    }

    public void setCaller(Contact caller) {
        this.caller = caller;
    }

    public Contact getCalee() {
        return calee;
    }

    public void setCalee(Contact calee) {
        this.calee = calee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
