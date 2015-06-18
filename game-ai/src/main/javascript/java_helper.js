function JavaHelper() {
    this.connector = new scheisse.game_ai.nashorn.NashornToJavaConnector();
    this.getProperty = function(metric, property) {
        return connector.getProperty("" + metric, "" + property);
    };
    this.push = function(metric, value) {
        connector.push("" + metric, value)
    };
    this.testConnection = function() {
        return (this.getProperty("utils.test", "ping") === true);
    };
    this.isJavaMob = function(mob) {
        return (mob.class === "scheisse.game_ai.behaviour.Mob");
    };
    this.getMob = function(id) {
        var mob = this.getProperty("game.mob.byId", id);
        if (!this.isJavaMob(mob)) {
            return false;
        }
        return mob;
    };
    this.newMob = function(mob) {
        var value = this.push("game.mob.new", mob);
        if (!isJavaMob(value)) {
            return false;
        }
        mob.javaObject = this.getMob(value);
        return mob;
    };
}

var javaHelper = new JavaHelper();
