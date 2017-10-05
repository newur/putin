package com.putin.calendarservice;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalendarEntry {
	
	private String id;
	private String name;
	private String description;
	private Date start;
	private Date end;	
	private String organizer;
	
	public CalendarEntry(){
		//TODO
	}
	
	public CalendarEntry(String id, String name, String description, Date start, Date end, String organizer) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.start = start;
		this.end = end;
		this.organizer = organizer;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}	
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	@Override
	public String toString() {
		return "CalendarEntry [id=" + id + ", name=" + name + ", description=" + description + ", start=" + start
				+ ", end=" + end + ", organizer=" + organizer + "]";
	}	
	
	
}
