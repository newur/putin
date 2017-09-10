// fill in your username and password for google services

const username = '';
const password = '';
const googleAlbumUrl = 'https://photos.google.com/albums';

var webdriver = require('selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;

var driver = new webdriver.Builder()
    .forBrowser(webdriver.Browser.FIREFOX)
    .build();

async function asyncWrapper() {
   
  driver.get(googleAlbumUrl);

  var usernameWebElement = driver.findElement(By.name('identifier'));

  usernameWebElement.sendKeys(username);
  usernameWebElement.sendKeys(webdriver.Key.ENTER);

  await driver.sleep(1000);
  
  var passwordElement = driver.findElement(By.name('password'));
  passwordElement.sendKeys(password);
  passwordElement.sendKeys(webdriver.Key.ENTER);

  // following code 'works', but seems like google blocks it
  // when data is entered too fast (between 800 and 700ms)
  //var pwdInDOM = driver.wait(until.elementLocated(By.name('password')), 5000);
  //pwdVisible = driver.wait(until.elementIsVisible(pwdInDOM), 5000);
  //pwdVisible.sendKeys(password);
  //pwdVisible.sendKeys(webdriver.Key.ENTER);

}

asyncWrapper();