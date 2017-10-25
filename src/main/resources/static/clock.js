Vue.component("clock", {
    template: `<div>
                    <component :is="variant"></component>
               </div>`,
    props: ['variant']
});

Vue.component("digital", {
	template: `<div id="clock">
                   <p class="time">{{ time }}</p>
                   <p class="date">{{ date }}</p>
               </div>`,
	data: function() {
		return {
			date: '',
			time: ''
		}
	},
	created: function() {
        this.updateTime();
        this.timer = setInterval(this.updateTime, 300000)
    },
    methods: {

        updateTime: function() {
            var cd = new Date();
            this.time = this.zeroPadding(cd.getHours(), 2) + ':' + this.zeroPadding(cd.getMinutes(), 2);
            this.date = week[cd.getDay()] + ", " + this.zeroPadding(cd.getDate(), 2) + '.' + this.zeroPadding(cd.getMonth()+1, 2) + '.' + this.zeroPadding(cd.getFullYear(), 4);
        },
        zeroPadding: function(num, digit){
            var zero = '';
            for(var i = 0; i < digit; i++) {
                zero += '0';
            }
            return (zero + num).slice(-digit);
        }

    }
});

var week = ['Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag'];

Vue.component("analog", {
	template: `<canvas id="clock" width="200" height="200">
               </canvas>`,
    data: function() {
    		return {
    			clock: ''
    		}
    },
    created: function() {
            this.clock = new AnalogClock("clock");
            this.timer = setInterval(this.updateTime, 1000)
    },
    methods: {
        updateTime: function() {
            this.clock.draw();
        }
    }
});


