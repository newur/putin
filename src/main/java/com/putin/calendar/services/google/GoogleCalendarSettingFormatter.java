package com.putin.calendar.services.google;

import com.google.api.services.calendar.model.CalendarListEntry;
import com.putin.user.UserSettingsProvider;
import com.putin.user.model.CalendarSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleCalendarSettingFormatter {


    private final UserSettingsProvider userSettingsProvider;

    @Autowired
    public GoogleCalendarSettingFormatter(UserSettingsProvider userSettingsProvider) {
        this.userSettingsProvider = userSettingsProvider;
    }

     public List<CalendarSetting> standardizeCalendarSettings(List<CalendarListEntry> calendars){
        List<CalendarSetting> calendarSettings = new ArrayList<>();
        for (CalendarListEntry entry : calendars) {
            CalendarSetting eCS = checkCalendarSelection(entry.getId());
            if(eCS!=null)
                calendarSettings.add(
                        new CalendarSetting("google", entry.getId(), entry.getSummary(),
                                entry.getDescription(), eCS.getColor(),
                                eCS.isSelected()));
            else
                calendarSettings.add(
                        new CalendarSetting("google", entry.getId(), entry.getSummary(),
                                entry.getDescription(), "#000000",
                                false));


        }
        return calendarSettings;
    }

    private CalendarSetting checkCalendarSelection(String id){
        for(CalendarSetting calendarSetting : userSettingsProvider.getUserSettings().getCalendarSettings()){
            if(calendarSetting.getId().equals(id))
                return calendarSetting;
        }
        return null;
    }
}
