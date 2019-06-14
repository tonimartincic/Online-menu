#!/bin/bash
mvn clean install
heroku deploy:jar backend/target/backend-0.0.1-SNAPSHOT.jar -a online-menu-tm
