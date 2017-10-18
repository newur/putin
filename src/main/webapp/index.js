window.onload = function () {

    var vm = new Vue({
      el: "#main",
      data: {
        calendarEvents: '',
      }
    });

    // get calendar events
    $.getJSON( "/calendarEvents", function( data ) {
        vm.calendarEvents=data;
    });


}