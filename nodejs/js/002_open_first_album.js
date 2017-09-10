var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;

var firefox = require('selenium-webdriver/firefox');

// use this profile with an already existing login cookie
// for google album. This creates an Profile object
// the actual profile is not modified!
profile = new firefox.Profile('/home/ruwen/.mozilla/firefox/selenium'); 

var driver = new webdriver.Builder()
    .forBrowser('firefox')
    .setFirefoxOptions(new firefox.Options().setProfile(profile))
    .build();

openFirstAlbum();

async function openFirstAlbum() {
	driver.get('https://photos.google.com/albums');

	await driver.sleep(1000);
	var albums = await driver.findElements(By.className('MTmRkb'));
	albums[1].click();

	await driver.sleep(1000);
}