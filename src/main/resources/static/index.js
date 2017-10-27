window.onload = function () {

    $.get( "/getUser", function( data ) {
        if (data==false) {
            try {
                window.stop();
            }
            catch (e) {
                document.execCommand('Stop');
            }
            window.location.replace("http://localhost:8080/createUser.html");
        }
        else{
            var vm = new Vue({
              el: "#main",
              data: {
                  settings: data
              },
              created: function() {
                  this.timer = setInterval(this.fetchSettings, 60000);
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
    });

}