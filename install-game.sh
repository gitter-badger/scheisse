#!/usr/bin/env bash

DESTINATION=~/.scheisse
DATA_DIR=$DESTINATION/data
SAVEGAME_DIR=$DESTINATION/savegame

function usage {
    echo "$0"
    return
}

function build {
    mvn clean package
    return
}

function create-dirs {
    if [ -d $DESTINATION ]; then
        rm -rf $DESTINATION
    fi
    mkdir $DESTINATION
    mkdir $DATA_DIR
    mkdir $SAVEGAME_DIR
    return
}

function copy-bins {
    cp ./game/target/game-1.0-SNAPSHOT-jar-with-dependencies.jar $DESTINATION/game.jar
    echo "#!/usr/bin/env bash" > $DESTINATION/game
    echo "java -jar game.jar" >> $DESTINATION/game
    chmod +x $DESTINATION/game
    return
}

function copy-res {
    cp -r ./game/game_files/data/* $DATA_DIR/
    cp -r ./game/game_files/version.dgm $DESTINATION/
    cp -r ./game/game_files/savegame/* $SAVEGAME_DIR/
    return
}

function link {
    ln -sf $DESTINATION/game ~/Desktop/Scheisse
    return
}

build
create-dirs
copy-bins
copy-res
link
