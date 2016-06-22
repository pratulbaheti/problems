# Obelisk - Using AngularJS, Angular-Datatables, Gulp, Bower, Browserify, Bootstrap

[GULP](http://gulpjs.com/plugins/) - Javascript task runner, used to automate repetitive tasks (i.e., minifying, linting, testing, building, compiling) to simplify the build process.

[BOWER](http://bower.io/) - Manage front-end dependencies and serve css/js etc from the downloaded repo configured.

[BROWSERIFY](http://browserify.org/) - Also manages front-end dependencies (mainly js) and works with NPM 'require' calls for including dependencies instead of script includes in the HTML documents.

Be sure to check [NPM](https://www.npmjs.com/) first before relying on Bower so you can take advantage of the simple require calls, via Browserify, which reduces code clutter and enables you to write modular, re-usable code.

## Quick Start

1. Install GIT (Git-2.5.2.2-64-bit.exe). Internal link at ```\\eng\ftl\teams\XD-Cloud\DevOps\Installers\Git-2.5.2.2-64-bit.exe```. Select ```Use Git from the Windows Prompt```. This adds GIT to the path.
1. Install python 3[.4].3 (```\\eng\ftl\teams\XD-Cloud\DevOps\Installers\python-3.4.3.msi```)
1. Install Node js - [Here](https://nodejs.org/) . Cache copy at ```\\eng\ftl\teams\XD-Cloud\DevOps\Installers\node-v0.12.7-x64.msi```
1. Clone the repo
1. Install the global requirements (run this command from any path): `npm install -g gulp bower browserify`
1. Install the local requirements (going ahead run all commands from repo directory path): `npm install`
1. Install the Bower components: `bower install`
1. If you plan to use https, SSL configurations need to be done before moving ahead (See below for SSL configurations)
1. Gulp default task for http, localhost, serve from ./app : `gulp`
1. Gulp build task for http, localhost, serve from ./build : `gulp build` (NOT WORKING FOR NOW)
1. Gulp http task for http, selfhost (0.0.0.0), serve from ./app : `gulp http`
1. Gulp http-build task for http, selfhost (0.0.0.0), serve from ./build : `gulp http-build` (NOT WORKING FOR NOW)
1. Gulp https task for https, selfhost (0.0.0.0), serve from ./app : `gulp https`
1. Gulp https-build task for https, selfhost (0.0.0.0), serve from ./build : `gulp https-build`  (NOT WORKING FOR NOW)


## SSL configuration

1. Get the ```wilcard.eng.citrite.net.key``` and ```wildcard.eng.citrite.net_exp20161119.crt``` certificate from the Cloud XD DevOps team.
1. SSL cert/key path : ./app/ssl/
    - Certificate file name :  rename ```wildcard.eng.citrite.net_exp20161119.crt``` to OBELISK_cert.pem
    - Key file name : rename ```wilcard.eng.citrite.net.key``` to OBELISK.key

## Take a look - Blog post

Be sure to read the blog posts to learn how to create this setup from scratch:

1. [Kickstarting Angular With Gulp and Browserify, Part 1 - Gulp and Bower](http://mherman.org/blog/2014/08/14/kickstarting-angular-with-gulp)
1. [Kickstarting Angular With Gulp and Browserify, Part 2 - Browserify](http://mherman.org/blog/2014/08/15/kickstarting-angular-with-gulp-and-browserify-part-2)

## Feature Toggles

#### Background
Features can be at control plane level, edition level and customer level. All customers are eligible for control plane level features. Edition level features are related to the licensing of the customer. The effective features for customer is merged set of all these features where customer features take priority over edition level which inturn takes priority over control plane features.
Each features have some settings and {Enabled : "True/False"} setting is must for every feature, its case sensitive and value "True/False" is a string.

#### Functionality
Each customer is eligible for certain features. Users for Obelisk has mechanism to Enable, Disable or apply default setting for customers. For eg, a feature name "GoogleAnalytics" is enabled at control plane level implies it is eligible for all the customers on that control plane level. If customer has "AzureVDI" licensing and corresponds to "AzureVDI" edition, which inturn has "Enabled: 'False" the effective setting will be false.

#### Usage
- Values in the dropdown are possible values for the corresponding feature. 
- Choosing Enable/Disable will create or modify settings at customer level which will override lower level settings. 
- Selecting "Default" value will remove the entries from the customer level features and default values which are either at control or edition level will be applied on customer.
