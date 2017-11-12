package com.leonis.leonisandrod.CallPackage;

import com.leonis.leonisandrod.ContactPackage.Contact;

import java.util.Comparator;

/**
 * Created by Floglor on 08.11.2017.
 */

public abstract class Call {
    static final String MISSED_CALL = "missed";
    static final String RECEIVED_CALL = "received";
    static final String OUTGOING_CALL = "outgoing";
    static final String MISSED_OUTGOING_CALL = "missed outgoing";

    //Null if it was user
    private Contact caller;

    //Null if it was user
    private Contact calee;

    private int duration;
    private String status;
    private long time;

    public Call(Contact caller, int duration, Contact calee, long time) {
        this.caller = caller;
        this.calee = calee;
        this.duration = duration;
        this.time = time;
    }

    public Call(Contact caller, int duration, String status, long time) {
        this.caller = caller;
        this.duration = duration;
        this.status = status;
        this.time = time;
    }

    public Call(int duration) {
        this.duration = duration;
    }

    static Comparator<Call> sortByTime = new Comparator<Call>() {
        @Override
        public int compare(Call o1, Call o2) {
            long CallTime1 = o1.getTime();
            long CallTime2 = o2.getTime();

            return Long.compare(CallTime1, CallTime2);
        }
    };

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

    public long getTime() {
        return time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
