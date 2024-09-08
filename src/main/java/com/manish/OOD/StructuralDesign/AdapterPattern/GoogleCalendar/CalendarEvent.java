package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

// Common interface for Calendar Event
public interface CalendarEvent {
    public String getTitle();

    public String getLocation();

    public Date getStartTime();

    public Date getEndTime();
}
