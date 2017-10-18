Vue.component("calendar", {
    template: `<div>
                    <li v-for="event in events">
                        <span> {{ event.name }} </span>
                    </li>
               </div>`,
    props: ['events']
});
