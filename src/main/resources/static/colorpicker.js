Vue.component("color-picker-dropdown", {
	template: `<div class="wrapper-dropdown">
	                <span @click="toggleDropdown()" v-html="selector"></span>
	                <ul class="dropdown" v-show="active">
                        <li v-for="color in colors" @click="setColor(color)">
                            <span :style="{background: color}"></span>
                        </li>
	                </ul>
	           </div>`,
	props: ['initial'],
	data: function() {
		return {
			active: false,
			selectedColor: this.initial,
			colors: colors,
		}
	},
	computed: {
		selector: function() {
			return '<span style="background: ' + this.selectedColor + '"></span> ';
		}
	},
	methods: {
		setColor: function(color) {
			this.selectedColor = color;
			this.active = false;
			this.$emit('input', this.selectedColor);
		},
		toggleDropdown: function() {
			this.active = !this.active;
		},
	}
});

var colors = ["#000000","#FFA07A","#CD5C5C","#DC143C","#20B2AA","#008B8B","#4682B4"];