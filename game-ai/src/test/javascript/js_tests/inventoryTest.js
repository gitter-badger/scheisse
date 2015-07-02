print("inventoryTest.js")

var success = true;
var errorMessages = [];

var fail = function() {
    success = false;
}

var inventory = new Inventory();

if (inventory.size() !== 0) {
    fail();
    errorMessages.push("wrong size");
}

if (inventory.containsItemWithId(1)) {
    fail();
    errorMessages.push("new inventory not empty");
}

inventory.add(1, 10);

if (inventory.numberOfItemWithId(1) !== 10) {
    fail();
    errorMessages.push("added items not there");
}

if (inventory.size() !== 1) {
    fail();
    errorMessages.push("wrong size");
}

inventory.remove(1, 4);

if (inventory.numberOfItemWithId(1) !== 6) {
    fail();
    errorMessages.push("didn't remove correctly");
}

if (inventory.size() !== 1) {
    fail();
    errorMessages.push("wrong size");
}

inventory.remove(1, 10);

if (inventory.numberOfItemWithId(1) !== 0) {
    fail();
    errorMessages.push("not empty after remove");
}

if (inventory.size() !== 0) {
    fail();
    errorMessages.push("wrong size");
}
