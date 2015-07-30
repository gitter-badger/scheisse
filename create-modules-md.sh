#!/usr/bin/env bash

MD_FILE=./MODULES.md
MODULES=$(cat ./pom.xml | sed -n "/<module>/,/<\/module>/p" | sed -r "s/<module>//g" | sed -r "s/<\/module>//g" | xargs)

if [ -f $MD_FILE ]; then
    rm $MD_FILE
fi

touch $MD_FILE
echo "# Modules" >> $MD_FILE
echo "" >> $MD_FILE

for i in $MODULES; do
    if [ -f $i/README.md ]; then
        echo "* [$i]($i/README.md)" >> $MD_FILE
    else
        echo "* [$i]($i)" >> $MD_FILE
    fi
done
