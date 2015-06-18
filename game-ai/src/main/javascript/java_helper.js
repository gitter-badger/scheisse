function JavaHelper() {
    this.connector = new scheisse.game_ai.nashorn.NashornToJavaConnector();
    this.getProperty = function(metric, property) {
        return connector.getProperty("" + metric, "" + property);
    };
    this.testConnection = function() {
        return (this.getProperty("utils.test", "ping") === true);
    };
}

var javaHelper = new JavaHelper();
