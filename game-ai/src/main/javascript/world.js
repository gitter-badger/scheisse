print("world.js");

function World() {
    this.maps = [];
    this.addMap = function(map) {
        var x = map.x;
        var y = map.y;
        if (typeof this.maps[x] !== 'array') {
            this.maps[x] = [];
        }
        this.maps[x][y] = map;
    };
    this.removeMap = function(map) {
        var x = map.x;
        var y = map.y;
        if (typeof this.maps[x][y] !== 'undefined') {
            this.maps[x].splice(y, 1);
        }
    };
    this.hasMapAt = function(x, y) {
        return typeof this.maps[x][y] !== 'undefined';
    };
}
