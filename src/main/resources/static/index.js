window.onload = function () {

    var vm = new Vue({
      el: "#main",
      data: {
        calendardata: '',
        settings: '',
        variant: 'calendarDays',
        clockvariant: 'analog'
      }
    });

    // get calendar data
    $.getJSON( "/"+vm.variant, function( data ) {
        vm.calendardata=data;
    });

    // get usersettings
    $.getJSON( "/getUser", function( data ) {
        vm.settings=data;
    });


}