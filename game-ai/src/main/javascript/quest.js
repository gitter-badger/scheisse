function QuestStore() {
    this.quests = new Object();
    this.hasQuest = function(id) {
        return !(this.quests[id] === undefined);
    };
    this.isCompleted = function(id) {
        if (!this.hasQuest(id)) {
            return false;
        }
        return this.quests[id].isCompleted();
    };
    this.allCompleted = function(ids) {
        for (id in ids) {
            if (!this.isCompleted(ids[id])) {
                return false;
            }
        }
        return true;
    };
    this.canPlayerAccept = function(level, id) {
        if (!this.hasQuest(id)) {
            return false;
        }
        var quest = this.quests[id];
        if (level < quest.minLevel) {
            return false;
        }
        for (dependingId in quest.dependsOn) {
            if (!this.isCompleted(quest.dependsOn[dependingId])) {
                return false;
            }
        }
        return true;
    };
}

var questStore = new QuestStore();

function Quest(id, minLevel, dependsOn, name, description, originId) {
    this.id = id;
    this.minLevel = minLevel;
    this.name = name;
    this.dependsOn = dependsOn;
    this.description = description;
    this.originId = originId;
    this.isCompleted = function() {return (this.nextHint === false);};
    this.nextHint = function() {return false;};
    this.nextWaypoint = function() {return {x: 0, y: 0};};
}

var registerQuest = function(quest) {
    questStore.quests[quest.id] = quest;
}
