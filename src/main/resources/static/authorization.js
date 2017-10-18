$.get( "/userExists", function( data ) {
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
});