print("inventoryTest.js")

var success = true;
var errorMessages = [];

var fail = function() {
    success = false;
}

var inventory = new Inventory();

if (inventory.size() !== 0) {
    fail();
    errorMessages.push(new Error().lineNumber + ": wrong size");
}

if (inventory.containsItemWithId(1)) {
    fail();
    errorMessages.push(new Error().lineNumber + ": new inventory not empty");
}

inventory.add(1, 10);

if (inventory.numberOfItemWithId(1) !== 10) {
    fail();
    errorMessages.push(new Error().lineNumber + ": added items not there");
}

if (!inventory.containsItemWithId(1)) {
    fail();
    errorMessages.push(new Error().lineNumber + ": added items not there");
}

if (inventory.size() !== 1) {
    fail();
    errorMessages.push(new Error().lineNumber + ": wrong size");
}

inventory.remove(1, 4);

if (inventory.numberOfItemWithId(1) !== 6) {
    fail();
    errorMessages.push(new Error().lineNumber + ": didn't remove correctly");
}

if (inventory.size() !== 1) {
    fail();
    errorMessages.push(new Error().lineNumber + ": wrong size");
}

inventory.remove(1, 10);

if (inventory.numberOfItemWithId(1) !== 0) {
    fail();
    errorMessages.push(new Error().lineNumber + ": not empty after remove");
}

if (inventory.size() !== 0) {
    fail();
    errorMessages.push(new Error().lineNumber + ": wrong size");
}

if (!success) {
    print("inventoryTest.js has failures:");
    var i = 0;
    while (i++ < errorMessages.length - 1) {
        print("Error: " + errorMessages[i]);
    }
}
