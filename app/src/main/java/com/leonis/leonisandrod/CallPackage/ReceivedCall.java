package com.leonis.leonisandrod.CallPackage;

import com.leonis.leonisandrod.ContactPackage.Contact;
import com.leonis.leonisandrod.TimeWorker;

/**
 * Created by Floglor on 09.11.2017.
 */

public class ReceivedCall extends Call {
    public ReceivedCall(Contact caller, int duration) {
        super(caller, duration, RECEIVED_CALL, TimeWorker.getTimeMinusDuration(duration));
    }
}
