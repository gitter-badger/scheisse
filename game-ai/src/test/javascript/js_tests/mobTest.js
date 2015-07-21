var filename = 'mobTest.js';
print(filename);

var success = true;
var errorMessages = [];

var ef = create_enemy(false);
var et = create_enemy(true);

var nf = create_neutral_mob(false);
var nt = create_neutral_mob(true);

var ff = create_friend(false);
var ft = create_friend(true);

var fail = function() {
    success = false;
}

if (ef.aggresive || ef.occupation !== mob_bad) {
    fail();
    errorMessages.push("incorrect enemy in line 19");
}
if (!et.aggresive || et.occupation !== mob_bad) {
    fail();
    errorMessages.push("incorrect enemy in line 23");
}

if (nf.aggresive || nf.occupation !== mob_neutral) {
    fail();
    errorMessages.push("incorrect neutral mob in line 28");
}
if (!nt.aggresive || nt.occupation !== mob_neutral) {
    fail();
    errorMessages.push("incorrect neutral mob in line 28");
}

if (ff.aggresive || ff.occupation !== mob_good) {
    fail();
    errorMessages.push("incorrect friend in line 37");
}
if (!ft.aggresive || ft.occupation !== mob_good) {
    fail();
    errorMessages.push("incorrect friend in line 41");
}
