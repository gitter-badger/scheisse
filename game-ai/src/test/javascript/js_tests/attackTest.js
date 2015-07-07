print("attackTest.js");

var success = true;
var errorMessages = [];

var fail = function() {
    success = false;
}

var fire = new Attack('fire', 100, 50);
var ice = new Attack('ice', 100, 50);
var shock = new Attack('shock', 100, 50);
var water = new Attack('water', 100, 50);

if (fire.damageAgainst(fire.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (fire.damageAgainst(ice.element) !== 180) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (fire.damageAgainst(shock.element) !== 145) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (fire.damageAgainst(water.element) !== 155) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}

if (ice.damageAgainst(ice.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}

if (fire.damageAgainst(fire.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}

if (water.damageAgainst(water.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}



if (!success) {
    print("inventoryTest.js has failures:");
    var i = 0;
    while (i++ < errorMessages.length - 1) {
        print("Error: " + errorMessages[i]);
    }
}
