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
    return this.javaHelper.getMob(id);
}
var _registerMob = function(mob) {
    if (mob === undefined) {
        return false;
    }
    if (javaHelper.isJavaMob(mob.javaObject)) {
        return mob.id;
    }
    return this.javaHelper.newMob(mob);
}
