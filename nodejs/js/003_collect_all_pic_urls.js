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

driver.get('https://photos.google.com/album/AF1QipP3POVao2zXrECmOPs_kRsneSOVz9qRHxVL7aFD');

findUrls();

async function findUrls() {
	var pictures = await driver.findElements(By.className('RY3tic'));

	var imgs = [];

	for (var i = 0; i < pictures.length; i++) {
		var img = await pictures[i].getCssValue('background-image');
		img = img.slice(5).split('=')[0];
		console.log(img);
		imgs.push(img);
	}
	return imgs;
}