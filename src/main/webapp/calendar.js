function loadCalendarEvents(){
	$.getJSON( "/calendarEvents", function( data ) {
	  var items = [];
	  $.each( data, function( i, calendarEntry ) {
		items.push( "<div class='events' id='" + calendarEntry.name + "'>" + calendarEntry.name + "</div>");
	  });
	 
	  $( "<ul/>", {
		"class": "leftlist",
		html: items.join( "" )
	  }).appendTo( "body" );
	});
}