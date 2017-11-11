package com.leonis.leonisandrod;

/**
 * Created by Floglor on 09.11.2017.
 */

public class MissedOutgoingCall extends Call {
    public MissedOutgoingCall(Contact caller, int duration) {
        super(caller, duration, MISSED_OUTGOING_CALL, TimeWorker.getTimeMinusDuration(duration));
    }
}
