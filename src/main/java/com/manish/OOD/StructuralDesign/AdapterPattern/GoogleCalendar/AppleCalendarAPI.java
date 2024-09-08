package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

// Third-party Apple Calendar API and event classes
class AppleCalendarAPI {
    public AppleCalendarEvent getEvent(String eventId) {
        // This method would interact with Apple's API to fetch event data
        return new AppleCalendarEvent("Project Sync", "Zoom", new Date(), new Date());
    }
}
