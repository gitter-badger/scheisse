function Util() {
    this.javaHelper = javaHelper;

    //tools:
    this.getDistance = function(dx, dy) {
        return Math.sqrt(dx * dx + dy * dy);
    };
    this.calculateDirection = function(dx, dy) {
        return Math.asin(dy / this.getDistance(dx, dy));
    };

    //mob:
    this.getMob = function(id) {
        if (id === undefined) {
            return false;
        }
        return this.javaHelper.getMob(id);
    };
    this.createMob = function(mob) {
        if (mob === undefined) {
            return false;
        }
        return this.javaHelper.push("game.mob.new", mob);
    };
}

var _ = new Util();
