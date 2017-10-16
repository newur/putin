package com.putin.calendar.services.google;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.putin.user.model.CalendarSetting;
import com.putin.user.util.UserSettingsMapper;

import java.util.ArrayList;
import java.util.List;

class GoogleCalendarSettingFormatter {

    static List<CalendarSetting> standardizeCalendarSettings(List<CalendarListEntry> calendars){
        List<CalendarSetting> calendarSettings = new ArrayList<>();
        for (CalendarListEntry entry : calendars) {
            calendarSettings.add(
                    new CalendarSetting("google", entry.getId(), entry.getSummary(),
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
