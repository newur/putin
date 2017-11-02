# putin

## Prerequist
Make sure you have a current *geckodriver* and update the path in the test. Currently test looks for `/usr/bin/geckodriver`.
Also you need environment variables *GOOGLE_USER* and *GOOGLE_PASSWORD* for login.

## Next / ToDos
* try to include geckodriver as resource into the project
* integrate selenium and spring, so it serves google pictures to the client

## Done
* ported the first part of the Selenium code from NodeJS to Java.
* added the most basic spring boot support. Just for demo purposes so far

## Google Calendar Support

### Prerequisites
* Create environment variable "putin_credentials" containing the path to a writable directory (e.g. "/home/<username>/.credentials")
* Run com.putin.Main - go to localhost:8080/usersettings in your browser
* Enter a username - click create user
* Log in to google and allow Putin to access calendar data and photos
* Select calendars to be synchronized

### Usage
* Go to localhost:8080/usersettings to edit synchronized calendars
* Go to localhost:8080/index to see events