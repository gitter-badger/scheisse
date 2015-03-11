#!/usr/bin/env bash
mvn clean install -pl game -am && cd game/ && ./copy_game_files.sh && cd target && java -jar game-1.0-SNAPSHOT.jar && cd ../..