print("event.js");

var eventHandler = new function() {
    this.gameCommonEventListeners = [];
    this.itemStoreEventListeners = [];
    this.npcStoreEventListeners = [];
    this.gameCommonEvent = function(event) {
        this.gameCommonEventListeners.foreach(
            function(listener) {
                listener.gameCommonEvent(event);
            }
        );
    };
    this.itemStoreEvent = function(event) {
        this.itemStoreEventListeners.foreach(
            function(listener) {
                listener.itemStoreEvent(event);
            }
        );
    };
    this.npcStoreEvent = function(event) {
        this.npcStoreEventListeners.foreach(
            function(listener) {
                listener.npcStoreEvent(event);
            }
        );
    };
    this.addGameCommonEventListener = function(listener) {
        if ('gameCommonEvent' in listener) {
            if (!this.gameCommonEventListeners.contains(listener)) {
                this.gameCommonEventListeners.push(listener);
            }
        }
    };
    this.addItemStoreEventListener = function(listener) {
        if ('itemStoreEvent' in listener) {
            if (!this.itemStoreEventListeners.contains(listener)) {
                this.itemStoreEventListeners.push(listener);
            }
        }
    };
    this.addNpcStoreEventListener = function(listener) {
        if ('npcStoreEvent' in listener) {
            if (!this.npcStoreEventListeners.contains(listener)) {
                this.npcStoreEventListeners.push(listener);
            }
        }
    };
    this.removeGameCommonEventListener = function(listener) {
        if (this.gameCommonEventListeners.contains(listener)) {
            this.gameCommonEventListeners.removeObj(listener);
        }
    };
    this.removeItemStoreEventListener = function(listener) {
        if (this.itemStoreEventListeners.contains(listener)) {
            this.itemStoreEventListeners.removeObj(listener);
        }
    };
    this.removeNpcStoreEventListener = function(listener) {
        if (this.npcStoreEventListeners.contains(listener)) {
            this.npcStoreEventListeners.removeObj(listener);
        }
    };
}
