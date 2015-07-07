print("inventory.js");

function Inventory() {
    this.items = [];
    this.containsItemWithId = function(id) {
        return this.indexOf(id) !== -1;
    };
    this.numberOfItemWithId = function(id) {
        if (!this.containsItemWithId(id)) {
            return 0;
        }
        var index = this.indexOf(id);
        return this.items[index][1];
    };
    this.add = function(id, number) {
        if (this.containsItemWithId(id)) {
            var index = this.indexOf(id);
            this.items[index][1] = this.items[index][1] + number;
        } else {
            this.items.push([id, number]);
        }
    };
    this.remove = function(id, number) {
        if (!this.containsItemWithId(id)) {
            return;
        }
        var index = this.indexOf(id);
        this.items[index][1] = this.items[index][1] - number;
        if (this.items[index][1] <= 0) {
            this.items.splice(index, 1);
        }
    };
    this.size = function() {
        return this.items.length;
    };
    this.indexOf = function(id) {
        var i = 0;
        while (i < this.items.length) {
            if (this.items[i][0] === id) {
                return i;
            }
            i++;
        }
        return -1;
    };
}
