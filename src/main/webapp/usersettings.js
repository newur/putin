window.onload = function () {

    var vm = new Vue({
      el: "#saveSettingsForm",
      data: {
        settings: '',
        msg: '',
      }
    });

    // get usersettings
    $.getJSON( "/getUser", function( data ) {
        vm.settings=data;
    });

    // submit form to save usersettings
    $("#saveSettingsForm").submit(function(event) {
          event.preventDefault();
          var $form = $( this ),
              url = $form.attr( 'action' );
          $.ajax({
              type: 'POST',
              url: url,
              data: JSON.stringify(vm.settings),
              success: function(data) {
                if(data==false){
                    vm.msg="Save failed"
                    $.getJSON( "/getUser", function( data ) {
                        vm.settings=data;
                    });
                }
                else {
                    vm.msg="Saved successfully";
                    setTimeout(function(){
                         vm.msg="";
                        },2500);
                }
              },
              contentType: "application/json",
              dataType: 'json'
          });
    });

}