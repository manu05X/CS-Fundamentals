package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

// Adapter for Google Calendar
public class GoogleCalendarAdapter implements CalendarEvent {
    private GoogleCalendarAPI googleCalendarAPI;
    private GoogleCalendarEvent googleCalendarEvent;

    public GoogleCalendarAdapter(GoogleCalendarAPI googleCalendarAPI, GoogleCalendarEvent googleCalendarEvent) {
        this.googleCalendarAPI = googleCalendarAPI;
        this.googleCalendarEvent = googleCalendarEvent;
    }

    public String getTitle() {
        return googleCalendarEvent.getSummary();
    }

    public String getLocation() {
        return googleCalendarEvent.getLocation();
    }

    public Date getStartTime() {
        return googleCalendarEvent.getStart();
    }

    public Date getEndTime() {
        return googleCalendarEvent.getEnd();
    }
}
