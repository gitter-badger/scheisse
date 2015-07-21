var filename = 'mapObjectsTest.js';
print(filename);

var success = true;
var errorMessages = [];

var fail = function() {
    success = false;
}

var door = new Door(0, 0);

if (door.x !== 0 || door.y !== 0) {
    fail();
    errorMessages.push(new Error().lineNumber + ": location not set properly");
}
if (door.passingDirections.length !== 0) {
    fail();
    errorMessages.push(new Error().lineNumber + ": passing directions already set");
}
var i = 0;
while (i < directions.length) {
    if (door.canPass(directions[i])) {
        fail();
        errorMessages.push(new Error().lineNumber + ": can pass door");
    }
    i++;
}

door.addDirection("up");

if (door.passingDirections.length !== 1) {
    fail();
    errorMessages.push(new Error().lineNumber + ": wrong number of directions");
}
if (!door.canPass('up')) {
    fail();
    errorMessages.push(new Error().lineNumber + ": can not pass door");
}
if (door.canPass('down')) {
    fail();
    errorMessages.push(new Error().lineNumber + ": can pass door");
}
if (door.canPass('left')) {
    fail();
    errorMessages.push(new Error().lineNumber + ": can pass door");
}
if (door.canPass('right')) {
    fail();
    errorMessages.push(new Error().lineNumber + ": can pass door");
}

door.addDirection('not defined direction');
if (door.passingDirections.length !== 1) {
    fail();
    errorMessages.push(new Error().lineNumber + ": wrong number of directions");
}
if (door.canPass('not defined direction')) {
    fail();
    errorMessages.push(new Error().lineNumber + ": can pass door in non defined direction");
}
