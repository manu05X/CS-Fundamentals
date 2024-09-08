package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

import java.util.Date;

class OutlookCalendarEvent {
    private String subject;
    private String location;
    private Date start;
    private Date end;

    public OutlookCalendarEvent(String subject, String location, Date start, Date end) {
        this.subject = subject;
        this.location = location;
        this.start = start;
        this.end = end;
    }

    public String getSubject() {
        return subject;
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
