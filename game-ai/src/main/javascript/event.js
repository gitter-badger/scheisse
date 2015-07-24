print("event.js");

var eventHandler = new function() {
    this.gameCommonEventListeners = new Array();
    this.itemStoreEventListeners = new Array();
    this.npcStoreEventListeners = new Array();
    this.gameCommonEvent = function(event) {
        var i = this.gameCommonEventListeners.length;
        while (i--) {
            this.gameCommonEventListeners[i].gameCommonEvent(event);
        }
    };
    this.itemStoreEvent = function(event) {
        var i = this.itemStoreEventListeners.length;
        while (i--) {
            this.itemStoreEventListeners[i].itemStoreEvent(event);
        }
    };
    this.npcStoreEvent = function(event) {
        var i = this.npcStoreEventListeners.length;
        while (i--) {
            this.npcStoreEventListeners[i].npcStoreEvent(event);
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
