#!/usr/bin/env bash

mvn clean test
cd server-web
./run-robot-tests.sh
cd -
