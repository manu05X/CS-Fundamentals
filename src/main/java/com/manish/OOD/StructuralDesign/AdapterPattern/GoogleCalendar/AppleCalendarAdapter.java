package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

// Adapter for Apple Calendar
public class AppleCalendarAdapter implements CalendarEvent {
    private AppleCalendarAPI appleCalendarAPI;
    private AppleCalendarEvent appleCalendarEvent;

    public AppleCalendarAdapter(AppleCalendarAPI appleCalendarAPI, AppleCalendarEvent appleCalendarEvent) {
        this.appleCalendarAPI = appleCalendarAPI;
        this.appleCalendarEvent = appleCalendarEvent;
    }

    public String getTitle() {
        return appleCalendarEvent.getTitle();
    }

    public String getLocation() {
        return appleCalendarEvent.getLocation();
    }

    public Date getStartTime() {
        return appleCalendarEvent.getStartDate();
    }

    public Date getEndTime() {
        return appleCalendarEvent.getEndDate();
    }
}
