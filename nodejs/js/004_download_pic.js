var fs = require('fs'),
    request = require('request');

var download = function(uri, filename, callback){
  request.head(uri, function(err, res, body){
    console.log('content-type:', res.headers['content-type']);
    console.log('content-length:', res.headers['content-length']);

    request(uri).pipe(fs.createWriteStream(filename)).on('close', callback);
  });
};

//download('https://lh3.googleusercontent.com/Tu96LycAvP8bFOVG4NRBUrIBsELKx6mRWSJyXWRi7WcaFAIh6KUHunF6YnNdJ8xm9WgHNntjpJAUxE-RGIdeNHDQSuaC_BRRrjsl6LzxDHevojhy58pxK9Wlbq8bOUHQR8V8HTJ3QPiYNDqCPkaP9fQ-8LigZ42Vjnq7lYPFnTkEO3maUowmBIdlznZl22iDiaQp9ibJRrPcVDhRUr2cv83083CCPSH4lrW74ul_IJZKiT9C_GJFjgA8refLqDHeddtQi_IHcALHHEaW-O_X7hQpOr_FqSf2FkBt5zDI9FflH8dtZ439Nsq9JsStDtYA66nIkm9mRc9hOmPKuFsJqzeSBUN6a54reBzKGO0ew8MBc8_Cr64fZC0hDscWtIsm4CRgrox-xB0xsQtYodfpt29MJwRH2efE9kxfuNTd1hUP__K70r7btVYEuwmfxwKZZv5-lrSCVDNXKEwT-HbsavwcLu_hAVxdiwiuCGU8JQu8-bwhSVDc8kQ0P5wNIRgIrZPECZxMvdIWWRyjAqhQLzo7skUELh-VOUliWOAD1n-H53PwSF63XD-qr2xMnwp9uq85rv3Hi-7J_JCCRYQs9wyRyeXXx-2ozUmQ47S8JcfKenXZtyt1', 'hussler_01.jpg', function(){
//  console.log('done');
//});

var urls = ['https://lh3.googleusercontent.com/Tu96LycAvP8bFOVG4NRBUrIBsELKx6mRWSJyXWRi7WcaFAIh6KUHunF6YnNdJ8xm9WgHNntjpJAUxE-RGIdeNHDQSuaC_BRRrjsl6LzxDHevojhy58pxK9Wlbq8bOUHQR8V8HTJ3QPiYNDqCPkaP9fQ-8LigZ42Vjnq7lYPFnTkEO3maUowmBIdlznZl22iDiaQp9ibJRrPcVDhRUr2cv83083CCPSH4lrW74ul_IJZKiT9C_GJFjgA8refLqDHeddtQi_IHcALHHEaW-O_X7hQpOr_FqSf2FkBt5zDI9FflH8dtZ439Nsq9JsStDtYA66nIkm9mRc9hOmPKuFsJqzeSBUN6a54reBzKGO0ew8MBc8_Cr64fZC0hDscWtIsm4CRgrox-xB0xsQtYodfpt29MJwRH2efE9kxfuNTd1hUP__K70r7btVYEuwmfxwKZZv5-lrSCVDNXKEwT-HbsavwcLu_hAVxdiwiuCGU8JQu8-bwhSVDc8kQ0P5wNIRgIrZPECZxMvdIWWRyjAqhQLzo7skUELh-VOUliWOAD1n-H53PwSF63XD-qr2xMnwp9uq85rv3Hi-7J_JCCRYQs9wyRyeXXx-2ozUmQ47S8JcfKenXZtyt1'];


function downloads(urls) {
	console.log('downloads');
	for(var i = 0; i < urls.length; i++) {
		download(urls[i], 'image' + i, () => console.log('saved file ' + i));
	}
	console.log('downloads done');
}

function download(uri, filename, callback){
  request.head(uri, function(err, res, body){
    console.log('content-type:', res.headers['content-type']);
    console.log('content-length:', res.headers['content-length']);

    request(uri).pipe(fs.createWriteStream(filename)).on('close', callback);
  });
};

downloads(urls);
