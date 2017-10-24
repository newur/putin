Vue.component("calendar", {
    template: `<div>
                    <component :is="variant" :calendardata="calendardata"></component>
               </div>`,
    props: ['calendardata','variant']
});

Vue.component("calendarEvents", {
    template: `<div>
                    <table>
                        <tr v-for="(event, index) in calendardata">
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
    props: ['calendardata']
});

Vue.component("calendarDays", {
    template: `<div>
                   <div v-for="day in calendardata">
                        <div style="font-weight: 600; color: #D3D3D3;"> {{ day.dayPrefix }} {{ day.dayString }}
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
    props: ['calendardata']
});
