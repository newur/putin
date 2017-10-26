window.onload = function () {

    var vm = new Vue({
      el: "#main",
      data: {
          settings: ''
      },
      created: function() {
          this.fetchSettings();
          this.timer = setInterval(this.fetchSettings, 60000)
      },
      methods: {
          fetchSettings: function() {
              var self = this;
              $.getJSON( "/getUser", function( data ) {
                  self.settings=data;
              });
          },
      }
    });

}