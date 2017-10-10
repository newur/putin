package com.putin.calendarservice.googlecalendar;

import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GoogleCalendarWebService {

	@RequestMapping("/getCalendars")
	Response getCalendars(String user) throws Exception {

		com.google.api.services.calendar.Calendar service = GoogleCalendarAuthorization.getCalendarService(user);

		CalendarList calendarList = service.calendarList()
				.list()
				.execute();
		List<CalendarListEntry> items = calendarList.getItems();
		return Response.ok(items).build();
	}

	@RequestMapping("/getEvents")
    Response getEvents(String user, String calendarId) throws Exception {

    	com.google.api.services.calendar.Calendar service = GoogleCalendarAuthorization.getCalendarService(user);

		Events events = service.events()
				.list(calendarId)
				.setMaxResults(30)
				.setTimeMin(new DateTime(new Date()))
				.setOrderBy("startTime")
				.setSingleEvents(true)
				.execute();
		List<Event> items = events.getItems();
		return Response.ok(items).build();
    }

}