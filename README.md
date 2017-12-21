fd-android-client
=================

Android Client for Freedomotic v2

[![Build Status](https://travis-ci.org/freedomotic/fd-android-client.svg?branch=master)](https://travis-ci.org/freedomotic/fd-android-client)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/7cef6bb11b3345d5b9a1cf64e21a22cb)](https://www.codacy.com/app/mcicolella/fd-android-client?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=freedomotic/fd-android-client&amp;utm_campaign=Badge_Grade)

## Scope of the project

This repository contains the implementation of an Android client for [Freedomotic](http://www.freedomotic.com).  
The aim of this project is to reproduce all features already integrated in our Java frontend, that's available [here](https://github.com/freedomotic/freedomotic/tree/master/plugins/devices/frontend-java).

To have a broad idea about its features you can have a look at our [YouTube channel](https://www.youtube.com/freedomotic).

## Pre-requirements

In order to execute this `fd-android-client` app, first you need to download and launch an instance of Freedomotic on your machine.
Freedomotic is a framework built in Java, so the only pre-requirement to make it running locally is to have a JRE8 installation on your machine.

### Download and launch the latest build of the framework

You can download the latest available daily build available [here](http://teamcity.jetbrains.com/guestAuth/repository/download/bt1177/.lastSuccessful/freedomotic-5.6.0-%7Bbuild.number%7D.zip)

The zipped version of this daily build contains a jar file, named `freedomotic.jar` that you can run by executing the following command:

```java
java -jar freedomotic.jar
```

### Freedomotic RESTful endpoints

Once launched, a local setup of Freedomotic RESTful APIs will be available at `http://localhost:9111`.

## License

This is an Open Source software released under the [GNU GPLv2](http://www.gnu.org/licenses/old-licenses/gpl-2.0.html) license.
