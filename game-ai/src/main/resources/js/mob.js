var good = 'good';
var bad = 'bad';
var neutral = 'neutral';

function Mob(occupation, aggresive) {
    this.x = 0;
    this.y = 0;
    this.setLocation = function(newX, newY) {this.x = newX; this.y = newY};

    this.occupation = occupation;
    this.aggresive = aggresive;
    this.setOccupation = function(newOccupation) {this.occupation = newOccupation};
    this.attacks = function(othersOccupation) {
        if (this.occupation == neutral)
            return aggresive;
        if (this.occupation == bad) {
            if (othersOccupation == bad)
                return false;
            else
                return this.aggresive;
        } else {
            if (othersOccupation == good)
                return false;
            else
                return this.aggresive;
        }
    };
}
