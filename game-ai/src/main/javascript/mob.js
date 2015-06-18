var mob_good = 'good';
var mob_bad = 'bad';
var mob_neutral = 'neutral';

function Mob(id) {
    this.id = id;
    this.speed = 1;
    this.name = "unnamed mob";
    this.javaObject = javaHelper.getProperty("game.mob.byId", id);
    this.occupation = occupation;
    this.aggresive = aggresive;
    this.setOccupation = function(newOccupation) {this.occupation = newOccupation};
    this.attacks = function(othersOccupation) {
        if (this.occupation == mob_neutral)
            return aggresive;
        if (this.occupation == mob_bad) {
            if (othersOccupation == mob_bad)
                return false;
            else
                return this.aggresive;
        } else {
            if (othersOccupation == mob_good)
                return false;
            else
                return this.aggresive;
        }
    };
    this.tick = function(dt) {
        return;
    };
    this.move = function(x, y) {};
    this.teleport = function(x, y) {
        this.x = x; this.y = y;
    };
}

var create_enemy = function(aggresive) {return new Mob(mob_bad, aggresive);};
var create_friend = function(aggresive) {return new Mob(mob_good, aggresive);};
var create_neutral_mob = function(aggresive) {return new Mob(mob_neutral, aggresive);};

var attacks = function(mob1, mob2) {return mob1.attacks(mob2.occupation);};

var stationary_trader = function(name) {
    var mob = new Mob(mob_neutral, false);
    mob.name = name;
    return mob;
}

var walking_trader = function(name) {
    var mob = new Mob(mob_neutral, false);
    mob.name = name;
    mob.targetPosition = {x: 0, y: 0};
    mob.move = function(newX, newY) {
        mob.targetPosition = {x:newX, y:newY};
    };
    mob.doWalk = function(dt) {
        if (x != targetPosition.x || y != targetPosition.y) {
            console.log("walking");
        }
    };
    mob.tick = function(dt) {
        mob.doWalk(dt);
        console.log("dt: " + dt);
    };
    return mob;
}
