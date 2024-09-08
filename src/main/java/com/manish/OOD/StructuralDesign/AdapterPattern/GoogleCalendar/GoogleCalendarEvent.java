package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

class GoogleCalendarEvent {
    private String summary;
    private String location;
    private Date start;
    private Date end;

    public GoogleCalendarEvent(String summary, String location, Date start, Date end) {
        this.summary = summary;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public String getSummary() {
        return summary;
    }

    public String getLocation() {
        return location;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
