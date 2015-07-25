#!/usr/bin/env bash

echo java files:
find . -name '*.java' | wc -l
echo java lines:
find . -name '*.java' | xargs cat | wc -l
echo
echo js files:
find . -name '*.js' | wc -l
echo js lines:
find . -name '*.js' | xargs cat | wc -l
echo
echo xhtml files:
find . -name '*.xhtml' | wc -l
echo xhtml lines:
find . -name '*.xhtml' | xargs cat | wc -l
echo
echo css files:
find . -name '*.css' | wc -l
echo css lines:
find . -name '*.css' | xargs cat | wc -l
echo
echo robot files:
find . -name '*.robot' | wc -l
echo robot lines:
find . -name '*.robot' | xargs cat | wc -l
