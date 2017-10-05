package com.putin.calendarservice;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarWebService {

	@RequestMapping("/getEvents")
    public Response getEvents() throws IOException{

    	com.google.api.services.calendar.Calendar service =
				CalendarRequest.getCalendarService();

		// List the next 10 events from the primary calendar.
		DateTime now = new DateTime(new Date());
		Events events1 = service.events().list("t5o9mukotad5bns8bboir1shr0@group.calendar.google.com")
				.setMaxResults(30)
				.setTimeMin(now)
				.setOrderBy("startTime")
				.setSingleEvents(true)
				.execute();
		List<Event> items = events1.getItems(); 
		
		// List the next 10 events from the secondary calendar.
		Events events2 = service.events().list("buttifux@gmail.com")
				.setMaxResults(30)
				.setTimeMin(now)
				.setOrderBy("startTime")
				.setSingleEvents(true)
				.execute();
		items.addAll(events2.getItems());
		List<CalendarEntry> calendarEntries = items.stream().map(event ->toCalendarEntry(event)).collect(Collectors.toList()); 
		GenericEntity<List<CalendarEntry>> calendarEntriesList = new GenericEntity<List<CalendarEntry>>(calendarEntries) { };
		return Response.ok(calendarEntriesList).build();
    }
    
    public static CalendarEntry toCalendarEntry(Event event){  
    	CalendarEntry newCalendarEntry = new CalendarEntry(event.getId(), event.getSummary(),event.getDescription(),datetimetoDate(event.getStart()),
    			datetimetoDate(event.getEnd()),event.getOrganizer().getDisplayName());
    	return newCalendarEntry;
    }
    
    public static Date datetimetoDate(EventDateTime datetime){
    	if(datetime==null)
    		return null;
    	else if(datetime.getDateTime()==null && datetime.getDate()!=null)
    		try {
				String target = datetime.getDate().toStringRfc3339();
	    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	    		
	    		Date result = df.parse(target);
	    		return result;
			} catch (ParseException e) {				
				return null;
			}     	
    	else{    		
			try {
				String target = datetime.getDateTime().toStringRfc3339();
	    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS");	    		
	    		Date result = df.parse(target);
	    		return result;
			} catch (ParseException e) {				
				return null;
			}      		
    	}
    }
    
    public static String dateToString(EventDateTime datetime){    	
    	if(datetime==null)
    		return "";
    	else if(datetime.getDateTime()==null && datetime.getDate()!=null)
    		try {
				String target = datetime.getDate().toStringRfc3339();
	    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	    		
	    		Date result = df.parse(target);
				DateFormat df2 = new SimpleDateFormat("EEEE, dd.MMMMM", Locale.GERMAN);
	    		return df2.format(result);
			} catch (ParseException e) {				
				return "";
			}     	
    	else{    		
			try {
				String target = datetime.getDateTime().toStringRfc3339();
	    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS");	    		
	    		Date result = df.parse(target);
				DateFormat df2 = new SimpleDateFormat("EEEE, dd.MMMMM", Locale.GERMAN);
	    		return df2.format(result);
			} catch (ParseException e) {				
				return "";
			}      		
    	}
    	
    }

}