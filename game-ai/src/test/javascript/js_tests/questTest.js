var filename = 'questTest.js';
print(filename);

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
