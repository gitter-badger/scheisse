print("utils.js");

//tools:
var _getDistance = function(dx, dy) {
    return Math.sqrt(dx * dx + dy * dy);
}
var _calculateDirection = function(dx, dy) {
    return Math.asin(dy / this.getDistance(dx, dy));
}

Array.prototype.contains = function(obj) {
    var i = this.length;
    while (i--) {
        if (this[i] == obj) {
            return true;
        }
    }
    return false;
}

Array.prototype.removeObj = function(obj) {
    var index = this.indexOf(obj);
    if (index > -1) {
        this.splice(index, 1);
    }
}
