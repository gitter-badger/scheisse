var filename = 'attackTest.js';
print(filename);

var fire = new Attack('fire', 100, 50);
var ice = new Attack('ice', 100, 50);
var shock = new Attack('shock', 100, 50);
var water = new Attack('water', 100, 50);

if (fire.damageAgainst(fire.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (fire.damageAgainst(ice.element) !== 180) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (fire.damageAgainst(shock.element) !== 145) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (fire.damageAgainst(water.element) !== 155) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}

if (ice.damageAgainst(ice.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (ice.damageAgainst(fire.element) !== 155) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (ice.damageAgainst(shock.element) !== 160) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (ice.damageAgainst(water.element) !== 165) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}

if (shock.damageAgainst(shock.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (shock.damageAgainst(fire.element) !== 155) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (shock.damageAgainst(ice.element) !== 145) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (shock.damageAgainst(water.element) !== 180) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}

if (water.damageAgainst(water.element) !== 150) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (water.damageAgainst(fire.element) !== 180) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (water.damageAgainst(ice.element) !== 145) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}
if (water.damageAgainst(shock.element) !== 155) {
    fail();
    errorMessages.push(new Error().lineNumber + ': incorrect damage.');
}

