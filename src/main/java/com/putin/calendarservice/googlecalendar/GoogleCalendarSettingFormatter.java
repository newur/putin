package com.putin.calendarservice.googlecalendar;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.putin.calendarservice.CalendarSetting;
import com.putin.user.UserSettingsMapper;

import java.util.ArrayList;
import java.util.List;

class GoogleCalendarSettingFormatter {

    static List<CalendarSetting> standardizeCalendarSettings(List<CalendarListEntry> calendars){
        List<CalendarSetting> calendarSettings = new ArrayList<>();
        for (CalendarListEntry entry : calendars) {
            calendarSettings.add(
                    new CalendarSetting("googlecalendar", entry.getId(), entry.getSummary(),
                            entry.getDescription(), checkCalendarSelection(entry.getId())));
        }
        return calendarSettings;
    }

    private static boolean checkCalendarSelection(String id){
        for(CalendarSetting calendarSetting : UserSettingsMapper.getUserSettings().getCalendarSettings()){
            if(calendarSetting.getId().equals(id) && calendarSetting.isSelected())
                return true;
        }
        return false;
    }
}
