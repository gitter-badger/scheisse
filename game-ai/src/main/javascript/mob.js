print("mob.js");

var mob_good = 'good';
var mob_bad = 'bad';
var mob_neutral = 'neutral';

function Mob(id) {
    this.id = id;
    this.x = 0;
    this.y = 0;
    this.speed = 1;
    this.name = "unnamed mob";
    this.occupation = "null";
    this.aggresive = false;
    this.attackTriggered = [];
    this.triggerAttack = function(id) {
        this.attackTriggered.push(id);
    };
    this.untriggerAttack = function(id) {
        this.attackTriggered.removeObj(id);
    };
    this.setOccupation = function(newOccupation) {
        this.occupation = newOccupation
    };
    this.attacks = function(mob) {
        if (attackTriggered.contains(mob.id)) {
            return true;
        }
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
    this.tickActions = [];
    this.tick = function(dt) {
        for (action in tickActions) {
            action(dt);
        }
    };
    this.move = function(x, y) {};
    this.teleport = function(x, y) {
        this.x = x; this.y = y;
    };
}

var create_enemy = function(aggresive) {
    var mob = new Mob(-1);
    mob.aggresive = aggresive;
    mob.occupation = mob_bad;
    return mob;
};
var create_friend = function(aggresive) {
    var mob = new Mob(-1);
    mob.aggresive = aggresive;
    mob.occupation = mob_good;
    return mob;
};
var create_neutral_mob = function(aggresive) {
    var mob = new Mob(-1);
    mob.aggresive = aggresive;
    mob.occupation = mob_neutral;
    return mob;
};

var attacks = function(mob1, mob2) {return mob1.attacks(mob2);};

var walking_mob = function(occupation, aggresive, name) {
    var mob = new Mob(occupation, aggresive);
    mob.name = name;
    mob.targetPosition = {x: 0, y: 0};
    mob.move = function(newX, newY) {
        mob.targetPosition = {x:newX, y:newY};
    };
    mob.doWalk = function(dt) {
        if (mob.x != targetPosition.x || mob.y != targetPosition.y) {
            var dx = targetPosition.x - mob.x;
            var dy = targetPosition.y - mob.y;
            if ((Math.abs(dx) < 0.01) && (Math.abs(dy) < 0.01)) {
                mob.teleport(targetPosition.x, targetPosition.y);
            }
            var direction = _calculateDirection(targetPosition.x - mob.x, targetPosition.y = mob.y);
            mob.x += Math.cos(direction) * speed * dt;
            mob.y += Math.sin(direction) * speed * dt;
        }
    };
    mob.tickActions.push(function(dt) {
        mob.doWalk(dt);
    });
    mob.id = mobId;
    return mob;
}

