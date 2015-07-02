print("map.js");

function Map(x, y) {
    this.x = x;
    this.y = y;
    this.width = 0;
    this.height = 0;
    this.objects = [];
    this.addObject = function(obj) {
        this.objects.push(obj);
    };
    this.removeObject = function(obj) {
        this.objects.removeObj(obj);
    };
}
