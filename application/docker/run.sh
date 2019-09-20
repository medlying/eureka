#!/bin/bash

#generate properties
java -XX:NativeMemoryTracking=detail -cp $APP_HOME/config/:/$APP_HOME/app.jar $APP_MAIN_CLASS $*