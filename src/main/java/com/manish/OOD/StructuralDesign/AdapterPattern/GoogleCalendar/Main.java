package com.manish.OOD.StructuralDesign.AdapterPattern.GoogleCalendar;

// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class to demonstrate the adapter pattern
public class Main {
    public static void main(String[] args) {
        // Google Calendar example
        GoogleCalendarAPI googleAPI = new GoogleCalendarAPI();
        GoogleCalendarEvent googleEvent = googleAPI.getEvent("event1");
        CalendarEvent googleCalendarAdapter = new GoogleCalendarAdapter(googleAPI, googleEvent);
        displayEventDetails(googleCalendarAdapter);

        // Apple Calendar example
        AppleCalendarAPI appleAPI = new AppleCalendarAPI();
        AppleCalendarEvent appleEvent = appleAPI.getEvent("event2");
        CalendarEvent appleCalendarAdapter = new AppleCalendarAdapter(appleAPI, appleEvent);
        displayEventDetails(appleCalendarAdapter);

        // Outlook Calendar example
        OutlookCalendarAPI outlookAPI = new OutlookCalendarAPI();
        OutlookCalendarEvent outlookEvent = outlookAPI.getEvent("event3");
        CalendarEvent outlookCalendarAdapter = new OutlookCalendarAdapter(outlookAPI, outlookEvent);
        displayEventDetails(outlookCalendarAdapter);
    }

    public static void displayEventDetails(CalendarEvent event) {
        System.out.println("Title: " + event.getTitle());
        System.out.println("Location: " + event.getLocation());
        System.out.println("Start Time: " + event.getStartTime());
        System.out.println("End Time: " + event.getEndTime());
        System.out.println();
    }
}

