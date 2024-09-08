package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

// Third-party Outlook Calendar API and event classes
class OutlookCalendarAPI {
    public OutlookCalendarEvent getEvent(String eventId) {
        // This method would interact with Outlook's API to fetch event data
        return new OutlookCalendarEvent("1:1 Meeting", "Office", new Date(), new Date());
    }
}
