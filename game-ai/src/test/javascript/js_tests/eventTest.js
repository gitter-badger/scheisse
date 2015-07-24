var filename = 'eventTest.js';
print(filename);

var gameCommonEventTriggered = false;

var gameCommonEventHandler = function() {
    this.gameCommonEvent = function(event) {
        if (event.getOtherData() === 'gameCommonEventData') {
            gameCommonEventTriggered = true;
        }
    };
}

var itemStoreEventTriggered = false;

var itemStoreEventHandler = function() {
    this.itemStoreEvent = function(event) {
        if (event.getOtherData() === 'itemStoreEventData') {
            itemStoreEventTriggered = true;
        }
    };
}

var npcStoreEventTriggered = false;

var npcStoreEventHandler = function() {
    this.npcStoreEvent = function(event) {
        if (event.getOtherData() === 'npcStoreEventData') {
            npcStoreEventTriggered = true;
        }
    };
}

if (typeof eventHandler !== 'object') {
    fail();
    errorMessages.push(new Error().lineNumber + ': eventHandler is not an object!');
}

if (typeof eventHandler.addGameCommonEventListener !== 'function') {
    fail();
    errorMessages.push(new Error().lineNumber + ': not a function!');
}

if (typeof eventHandler.addItemStoreEventListener !== 'function') {
    fail();
    errorMessages.push(new Error().lineNumber + ': not a function!');
}

if (typeof eventHandler.addNpcStoreEventListener !== 'function') {
    fail();
    errorMessages.push(new Error().lineNumber + ': not a function!');
}

if (typeof eventHandler.gameCommonEvent !== 'function') {
    fail();
    errorMessages.push(new Error().lineNumber + ': not a function!');
}

if (typeof eventHandler.itemStoreEvent !== 'function') {
    fail();
    errorMessages.push(new Error().lineNumber + ': not a function!');
}

if (typeof eventHandler.npcStoreEvent !== 'function') {
    fail();
    errorMessages.push(new Error().lineNumber + ': not a function!');
}
