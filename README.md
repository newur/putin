# putin

## Prerequist
One needs a running NodeJS server and npm installed to run the .js files.

## How to get started
Currently only some NodeJS files are ready. They provide seperate functions to login into google photos, open the first album and an example howto download a photo + a combined file.

Navigate into the 'nodejs' folder and run 'npm install'. This will install required dependencies into your folder. Afterwards, run 'node 100_combine_google_photo_actions.js _your gmail address_ _your password_' to execute the code.

## Hints for testing
Some files require a mozilla profile called 'selenium' with a valid login cookie for google album. This is currently the only way to avoid a login before every test run  (which can be annoyingly slow). How to create a firefox profile: https://support.mozilla.org/en-US/kb/profile-manager-create-and-remove-firefox-profiles

If your internet connection is very slow, some functions might fail.