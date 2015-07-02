print("inventory.js");

function Inventory() {
    this.items = [];
    this.containsItemWithId = function(id) {
        return this.numberOfItemWithId(id) > 0;
    };
    this.numberOfItemWithId = function(id) {
        if (typeof this.items[id] === 'undefined') {
            return 0;
        }
        return this.items[id];
    };
    this.add = function(id, number) {
        if (this.containsItemWithId(id)) {
            this.items[id] = this.items[id] + number;
        } else {
            this.items[id] = number;
        }
    };
    this.remove = function(id, number) {
        if (!this.containsItemWithId(id)) {
            return;
        }
        this.items[id] = this.items[id] - number;
        if (this.items[id] < 0) {
            this.items[id] = 0;
        }
    };
}
