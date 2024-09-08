package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

// Adapter for Microsoft Outlook Calendar
public class OutlookCalendarAdapter implements CalendarEvent {
    private OutlookCalendarAPI outlookCalendarAPI;
    private OutlookCalendarEvent outlookCalendarEvent;

    public OutlookCalendarAdapter(OutlookCalendarAPI outlookCalendarAPI, OutlookCalendarEvent outlookCalendarEvent) {
        this.outlookCalendarAPI = outlookCalendarAPI;
        this.outlookCalendarEvent = outlookCalendarEvent;
    }

    public String getTitle() {
        return outlookCalendarEvent.getSubject();
    }

    public String getLocation() {
        return outlookCalendarEvent.getLocation();
    }

    public Date getStartTime() {
        return outlookCalendarEvent.getStart();
    }

    public Date getEndTime() {
        return outlookCalendarEvent.getEnd();
    }
}
