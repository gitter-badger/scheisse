_mobStore = _gameStore.getMobStore();

//tools:
var _getDistance = function(dx, dy) {
    return Math.sqrt(dx * dx + dy * dy);
}
var _calculateDirection = function(dx, dy) {
    return Math.asin(dy / this.getDistance(dx, dy));
}

//mob:
var _loadMob = function(id) {
    if (id === undefined) {
        return false;
    }
    return _mobStore.getMob(id);
}
var _registerMob = function(mob) {
    if (mob === undefined) {
        return false;
    }
    return _mobStore.putMob(mob);
}
