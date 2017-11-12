package com.leonis.leonisandrod.callpackage;

import com.leonis.leonisandrod.ContactPackage.Contact;
import com.leonis.leonisandrod.TimeWorker;

/**
 * Created by Floglor on 09.11.2017.
 */

public class MissedCall extends Call {
    public MissedCall(Contact caller, int duration) {
        super(caller, duration, MISSED_CALL, TimeWorker.getTimeMinusDuration(duration));
    }
}
