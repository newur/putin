# putin

## Prerequist
One needs a running node server and npm installed to run the files.

## How to get started
Currently only some NodeJS files are ready. They provide seperate functions to login into google photos, open the first album and an example howto download a photo.

Navigate into the 'nodejs' folder and run 'npm install'. This will install required dependencies into your folder. Afterwards, run 'node <file title>' to execute the code.

The login file requires that one enters its username and password for google (make sure to not check that in)!

The other files require a mozilla profile called 'selenium' with a valid login cookie for google album. This is currently the only way to avoid a login before every test run.