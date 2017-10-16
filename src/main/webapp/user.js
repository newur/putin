function checkIfUserExists(){
    $.get( "/userExists", function( data ) {
        console.log(data);
        if (data==false) {
            try {
                window.stop();
            }
            catch (e) {
                document.execCommand('Stop');
            }
            window.location.replace("http://localhost:8080/createUser.html");
        }
    });
}

function authorizeToGoogle(){
    $.get( "/checkGoogleAuthorization", function( data ) {
        if (data!="success") {
            try {
                window.stop();
            }
            catch (e) {
                document.execCommand('Stop');
            }
            window.location.replace(data);
        }
    });
}