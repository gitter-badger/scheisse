print("attack.js");

function Attack(element, baseDmg, elementalDmg) {
    this.element = element;
    this.baseDmg = baseDmg;
    this.elementalDmg = elementalDmg;
    this.damageAgainst = function(element) {
        var elem = this.elementalDmg;
        if (attack_types['efficiency'][this.element] === undefined || attack_types['efficiency'][element] === undefined) {
            return this.baseDmg + elem;
        }
        elem = elem * attack_types['efficiency'][this.element][element];
        return this.baseDmg + elem;
    };
}
