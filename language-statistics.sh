#!/usr/bin/env bash

echo -n "java files: "
find . -name '*.java' | wc -l
echo -n "java lines: "
find . -name '*.java' | xargs cat | wc -l
echo
echo -n "js files: "
find . -name '*.js' | wc -l
echo -n "js lines: "
find . -name '*.js' | xargs cat | wc -l
echo
echo -n "xhtml files: "
find . -name '*.xhtml' | wc -l
echo -n "xhtml lines: "
find . -name '*.xhtml' | xargs cat | wc -l
echo
echo -n "css files: "
find . -name '*.css' | wc -l
echo -n "css lines: "
find . -name '*.css' | xargs cat | wc -l
echo
echo -n "robot files: "
find . -name '*.robot' | wc -l
echo -n "robot lines: "
find . -name '*.robot' | xargs cat | wc -l
