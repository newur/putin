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
	template: `<div>
	                <canvas id="clock" width="200" height="200">
                    </canvas>
               </div>`,
    data: function() {
    		return {
    			clock: ''
    		}
    },
	mounted: function() {
	    this.clock = new StationClock("clock");
        this.clock.body = StationClock.RoundBody;
        this.clock.dial = StationClock.SwissStrokeDial;
        this.clock.hourHand = StationClock.SwissHourHand;
        this.clock.minuteHand = StationClock.SwissMinuteHand;
        this.clock.secondHand = StationClock.SwissSecondHand;
        this.clock.boss = StationClock.NoBoss;
        this.clock.minuteHandBehavoir = StationClock.BouncingMinuteHand;
        this.clock.secondHandBehavoir = StationClock.OverhastySecondHand;
        this.timer = setInterval(this.clock.draw(), 1000);
    },
});


