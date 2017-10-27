Vue.component("calendar", {
    template: `<div class="calendardiv">
                    <component :is="variant"></component>
               </div>`,
    props: ['variant']
});

Vue.component("events", {
    template: `<div>
                    <table>
                        <tr v-for="(event, index) in this.calendardata">
                           <td>
                                <div :style="{color: event.color}">{{event.startDayAsString}}</div>
                           </td>
                           <td>
                                <div :style="{color: event.color}">{{event.startAsString}} - {{event.endAsString}}</div>
                           </td>
                           <td>
                                <div :style="{color: event.color}">{{event.name}}</div>
                           </td>
                        </tr>
                    </table>
               </div>`,
    data: function(){
        return {
            calendardata: '',
        }
    },
    mounted: function() {
            this.updateCalendar();
            this.timer = setInterval(this.updateCalendar, 60000)
    },
    methods: {
        updateCalendar: function() {
            var self = this;
            $.getJSON( "/calendarEvents", function( data ) {
                self.calendardata=data;
            });
        },
    }
});

Vue.component("days", {
    template: `<div>
                   <div v-for="day in this.calendardata">
                        <div style="font-weight: 600; color: #F0FFFF;"> {{ day.dayPrefix }} {{ day.dayString }}
                          <table>
                              <tr v-for="dea in day.assignedCalendarEvents">
                                  <td>
                                      <div style="font-weight: 600" :style="{color: dea.calendarEvent.color}">{{dea.prefix}} {{dea.calendarEvent.name}} {{dea.suffix}}</div>
                                  </td>
                              </tr>
                          </table>
                       </div>
                       </br>
                   </div>
               </div>`,
    data: function(){
        return {
            calendardata: '',
        }
    },
    mounted: function() {
            this.updateCalendar();
            this.timer = setInterval(this.updateCalendar, 60000)
    },
    methods: {
        updateCalendar: function() {
            var self = this;
            $.getJSON( "/calendarDays", function( data ) {
                self.calendardata=data;
            });
        },
    }
});