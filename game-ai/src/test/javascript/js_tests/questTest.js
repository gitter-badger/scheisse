print("questTest.js");

var success = true;
var errorMessages = [];

var fail = function() {
    success = false;
}

if (typeof questStore === 'undefined') {
    fail();
    errorMessages.push(new Error().lineNumber + ": quest store not set");
}
if (questStore.quests.size() !== 0) {
    fail();
    errorMessages.push(new Error().lineNumber + ": quest store not empty");
}

if (!success) {
    print("inventoryTest.js has failures:");
    var i = 0;
    while (i++ < errorMessages.length - 1) {
        print("Error: " + errorMessages[i]);
    }
}
