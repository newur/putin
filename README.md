# putin

## Java Part

### Prerequist
Make sure you have a current *geckodriver* and update the path in the test. Currently test looks for `/usr/bing/eckodriver`. Also you need environment variables *GOOGLE_USER* and *GOOGLE_PASSWORD* for login.

### Next / ToDos
* try to include geckodriver as resource into the project
* integrate selenium and spring, so it serves google pictures to the client

### Done
* ported the first part of the Selenium code from NodeJS to Java.
* added the most basic spring boot support. Just for demo purposes so far

***

## NodeJS Part

### Prerequist
One needs a running NodeJS server and npm installed to run the .js files.

### How to get started
Navigate into the 'nodejs' folder and run 'npm install'. This will install required dependencies into your folder. Afterwards, run 'node 100_combine_google_photo_actions.js _yourGmailAddress_ _yourPassword_' to execute the code. This will cause:
* start a firefox instance (controlled by selenium)
* navigate to http://www.photos.google.com/albums (gets redirected by google to login page)
* login with the credentials you provided on the command line
* open the first album
* grab the urls of all pictures in the album
* download the pictures

### Hints for testing
Some files require a mozilla profile called 'selenium' with a valid login cookie for google album. This is currently the only way to avoid a login before every test run  (which can be annoyingly slow). How to create a firefox profile: https://support.mozilla.org/en-US/kb/profile-manager-create-and-remove-firefox-profiles

If your internet connection is very slow, some functions might fail.