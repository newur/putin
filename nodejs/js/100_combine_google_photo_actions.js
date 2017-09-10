const username = process.argv[2];
const password = process.argv[3];
const googleAlbumUrl = 'https://photos.google.com/albums';

var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;

var firefox = require('selenium-webdriver/firefox');

var fs = require('fs'),
    request = require('request');

var driver = new webdriver.Builder()
    .forBrowser('firefox')
 //   .setFirefoxOptions(new firefox.Options()
// 			.setProfile(new firefox.Profile('/home/ruwen/.mozilla/firefox/selenium')))
    .build();

main();

async function main() {
	await login();
	await openFirstAlbum();

	var urls = await findUrls();

	downloads(urls);
}

async function login() {
  driver.get(googleAlbumUrl);

  var usernameWebElement = driver.findElement(By.name('identifier'));

  usernameWebElement.sendKeys(username);
  usernameWebElement.sendKeys(webdriver.Key.ENTER);

  await driver.sleep(1000);
  
  var passwordElement = driver.findElement(By.name('password'));
  passwordElement.sendKeys(password);
  passwordElement.sendKeys(webdriver.Key.ENTER);

  await driver.sleep(1500);
}

async function openFirstAlbum() {
	console.log('openFirstAlbum');
	driver.get('https://photos.google.com/albums');

	var albums = await driver.findElements(By.className('MTmRkb'));
	albums[1].click();

	await driver.sleep(2000);
	console.log('openFirstAlbum done');
}

async function findUrls() {
	console.log('findUrls');
	var pictures = await driver.findElements(By.className('RY3tic'));

	var imgs = [];

	for (var i = 0; i < pictures.length; i++) {
		var img = await pictures[i].getCssValue('background-image');
		img = img.slice(5).split('=')[0];
		//console.log(img);
		imgs.push(img);
	}

	console.log('findUrls done');
	return imgs;
}

function downloads(urls) {
	console.log('downloads');
	for(var i = 0; i < urls.length; i++) {
		download(urls[i], 'image_' + i + '.jpg', () => console.log('downloaded ' + i + ' in total'));
	}
	console.log('downloads done');
}

function download(uri, filename, callback) {
	console.log('download');
	request.head(uri, function(err, res, body) {
		console.log('content-type:', res.headers['content-type']);
		console.log('content-length:', res.headers['content-length']);

		request(uri).pipe(fs.createWriteStream(filename)).on('close', callback);
	});
  console.log('download done');
};

