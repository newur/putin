var fs = require('fs'),
    request = require('request');

var download = function(uri, filename, callback){
  request.head(uri, function(err, res, body){
    console.log('content-type:', res.headers['content-type']);
    console.log('content-length:', res.headers['content-length']);

    request(uri).pipe(fs.createWriteStream(filename)).on('close', callback);
  });
};

download('https://lh3.googleusercontent.com/_6UGSpkApZnb6jAJSqCifNAQcpDhHTKHTJ48HmlCHmwuWBgGHM7d5DQ8g7dKKSauo6MSp12XUVDr2T6JNzdUoaDqLN2ErhLijobCxouT5oIZzlT2L-79p4H7EEOuO9Y8FyjJGKtDreR1D33i1H7bUDsPOEXSy68Sqn4QBRE5Trcp_xXGKPUQ4mTI0mNMEY6IKJ3Oei7FpLBrrB1XP7bmHhSFMRxgs7LJoUGH-Ctq5svyTbqAGkh30HtXjKUHR6a8yGHlZIkS5-ClJ2KNlAYbmkGNmkJgt2XP2sb6U3psegxVhwFFojcMdrr9pTGDqfQ1g4NzztJd0bKVne_Z2vYdhhyI9kG0NlgM5zaOUiLfgow6WHyxoJxjD9i94VgNVgAs0wTVKv0ApT2UuRaaVW-IlN5w331RtDMEF2tCpnDewDKrd2CGVvZzH-DsDAm7m-fklc-kKlEwgN2_h8Xdc6VxZMI-P42jPEhSA6BIB-iPT4YB3vX47W6Q-7dh2pMuuNN5nQ8_M7mbv27m5UtLuDDzYoDWPFDXAgihHaxexDYPTu7V8tb2IlOZAGX6Feyu87rrN9aaVpiCGUa6xVbXpHtbTE0U7r8yPybKBjK_voKKYDB0UEjFVNPD=w700-h466-no', 'hussler_01.jpg', function(){
  console.log('done');
});
