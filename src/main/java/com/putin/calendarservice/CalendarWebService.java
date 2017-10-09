package com.putin.calendarservice;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarWebService {

	@RequestMapping("/getCalendars")
	public Response getCalendars(String user) throws Exception {

		com.google.api.services.calendar.Calendar service = CalendarRequest.getCalendarService(user);

		CalendarList calendarList = service.calendarList()
				.list()
				.execute();
		List<CalendarListEntry> items = calendarList.getItems();
		return Response.ok(items).build();
	}

	@RequestMapping("/getEvents")
    public Response getEvents(String user, String calendarId) throws Exception {

    	com.google.api.services.calendar.Calendar service = CalendarRequest.getCalendarService(user);

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