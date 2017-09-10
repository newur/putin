//headless firefox

var webdriver = require('selenium-webdriver');
var firefox = require('selenium-webdriver/firefox');

var binary = new firefox.Binary(firefox.Channel.NIGHTLY);
binary.addArguments("-headless");

var driver = new webdriver.Builder()
    .forBrowser('firefox')
    .setFirefoxOptions(new firefox.Options().setBinary(binary))
    .build();