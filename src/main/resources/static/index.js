window.onload = function () {

    var vm = new Vue({
      el: "#main",
      data: {
        calendardata: '',
        variant: 'calendarEvents'
      }
    });

    // get calendar data
    $.getJSON( "/"+vm.variant, function( data ) {
        vm.calendardata=data;
    });


}