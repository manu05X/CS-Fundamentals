package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

// Third-party Google Calendar API and event classes
class GoogleCalendarAPI {
    public GoogleCalendarEvent getEvent(String eventId) {
        // This method would interact with Google's API to fetch event data
        return new GoogleCalendarEvent("Team Meeting", "Conference Room", new Date(), new Date());
    }
}
