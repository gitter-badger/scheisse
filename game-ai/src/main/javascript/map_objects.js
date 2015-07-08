print("map_objects.js");

function Door(x, y) {
    this.x = x;
    this.y = y;
    this.passingDirections = [];
    this.addDirection = function(direction) {
        if (!directions.contains(direction)) {
            return;
        }
        if (this.passingDirections.contains(direction)) {
            return;
        }
        this.passingDirections.push(direction);
    };
    this.removeDirection = function(direction) {
        this.directions.remove(direction);
    };
    this.canPass = function(direction) {
        return this.passingDirections.contains(direction);
    }
}
