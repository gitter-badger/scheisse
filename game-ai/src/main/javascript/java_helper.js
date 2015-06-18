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
        return (mob.class === "org.dedda.games.scheisse.state.game.object.npc.NPC");
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
        if (!(value.class === "org.dedda.games.scheisse.state.game.object.npc.NPC")) {
            return false;
        }
        mob.javaObject = this.getMob(value);
        return mob;
    };
}

var javaHelper = new JavaHelper();
