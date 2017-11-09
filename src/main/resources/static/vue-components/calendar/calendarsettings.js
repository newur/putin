Vue.component("calendarsettings", {
    template: `<div>
                   <div class="settingsbox">
                        <div class="settingsboxtitle">
                            <span>Kalenderlayout</span>
                        </div>
                        <div class="settingsoption">
                            <span class="settingslabel">
                                Layout
                            </span>
                            <span class="settingsvalue">
                                <select style="height: 14px;" v-model="settings.calendarSettings.calendarType">
                                    <option disabled value="">Bitte auswählen</option>
                                    <option value="days">Übersicht</option>
                                    <option value="events">Terminliste</option>
                                </select>
                            </span>
                        </div>
                        <div class="settingsoption">
                            <span class="settingslabel">
                                Angezeigte Tage
                             </span>
                            <span class="settingsvalue">
                                <input class="settingsinput" v-model="settings.calendarSettings.maxDays">
                            </span>
                        </div>
                   </div>

                   <div class="settingsbox">
                       <div class="settingsboxtitle">
                           <span>Ausgewählte Kalender</span>
                       </div>
                       <div class="settingsoption">
                           <table id="selectedCalendarsTable" border="0" style="text-align:left">
                              <tbody>
                                  <tr v-for="calendar in settings.calendarSettings.calendars">
                                      <td><img width="16" :src="typeimg(calendar.type)"></img></td>
                                      <td>{{ calendar.name }}</td>
                                      <td><color-picker-dropdown v-model="calendar.color" :initial="calendar.color" ></color-picker-dropdown></td>
                                      <td><button @click="removeCalendar(calendar)">Remove</button></td>
                                  </tr>
                              </tbody>
                          </table>
                       </div>
                   </div>
                   <div class="settingsbox">
                       <div class="settingsboxtitle">
                           <span>Kalender hinzufügen</span>
                       </div>
                       <div class="settingsoption">
                          <div>
                              <a @click="setCalendarType('google')"><img width="32" src="/img/google_icon_128.png"></img></a>
                              <a @click="setCalendarType('google')"><img width="32" src="/img/icalendar_icon_128.png"></img></a>
                          </div>
                          <div v-for="calendar in availableCalendars" v-if="calendar.type===selectedCalendarType">
                              <span>{{ calendar.id }}</span>
                              <span>{{ calendar.name }}</span>
                              <button @click="addCalendar(calendar)">Add</button>
                          </div>
                       </div>
                   </div>

                   <button class="savesettingsbtn" @click="save()">Speichern</button>
               </div>`,
    props: ['settings'],
    data: function(){
        return {
            availableCalendars: [],
            selectedCalendarType: ''
        }
    },
    methods:{
        setCalendarType: function(type){
          this.selectedCalendarType=type;
          this.loadAvailableCalendars();
        },
        addCalendar: function(calendar){
          this.settings.calendarSettings.calendars.push(calendar);
          this.availableCalendars = $.grep(this.availableCalendars, function(e){
                                        return e.id != calendar.id;
                                     });
        },
        removeCalendar: function(calendar){
          this.settings.calendarSettings.calendars =
                        $.grep(this.settings.calendarSettings.calendars, function(e){
                            return e.id != calendar.id;
                        });
          this.availableCalendars.push(calendar);
        },
        loadAvailableCalendars: function(){
            var self = this;
            $.post("/restGetAvailableCalendarsOfType", {'type': self.selectedCalendarType}, function(data, textStatus) {
              self.availableCalendars = data;
            },"json");
        },
        typeimg: function(type){
            return "/img/"+type+"_icon_128.png";
        },
        save: function(){
            this.$parent.$options.methods.save(this.settings);
        }
    }
});