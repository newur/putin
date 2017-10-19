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
                        <div> {{ day.dayRepresentation }}
                          <table>
                              <tr v-for="event in day.calendarEvents">
                                  <td>
                                      <div :style="{color: event.color}">{{event.startAsString}}</div>
                                      <div :style="{color: event.color}">{{event.name}}</div>
                                  </td>
                              </tr>
                          </table>
                       </div>
                   </div>
               </div>`,
    props: ['calendardata']
});
