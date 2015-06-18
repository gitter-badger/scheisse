function QuestStore() {
    this.quests = new Object();
    this.registerQuest = function(quest) {
        if (this.quests[quest.id] === undefined) {
            this.quests[quest.id] = quest;
            return true;
        }
        return false;
    };
    this.getQuest = function(id) {
        return quests[id];
    };
    this.isCompleted = function(id) {
        if (this.quests[id] === undefined) {
            return false;
        }
        return this.quests[id].isCompleted();
    };
    this.allCompleted = function(ids) {
        var allCompleted = true;
        for (id in ids) {
            if (!this.isCompleted(id)) {
                allCompleted = false;
                return allCompleted;
            }
        }
        return allCompleted;
    };
    this.canPlayerAccept = function(level, id) {
        var quest = this.quests[id];
        if (quest === undefined) {
            return false;
        }
        if (level < quest.minLevel) {
            return false;
        }
        return this.allCompleted(quest.dependsOn);
    };
}

var questStore = new QuestStore();

function Quest(id, minLevel, dependsOn, description, originId) {
    this.id = id;
    this.minLevel = minLevel;
    this.dependsOn = dependsOn;
    this.description = description;
    this.originId = originId;
    this.isCompleted = function() {return false;}
}
