#!/usr/bin/env bash

cd src/test/robot/testcases/
ls *.robot | xargs pybot
cd -
