USE `scheisse`;

-- users

INSERT INTO user(id, username, passwordHash, email, experience)
    VALUES(1, 'dedda', 'cfcd208495d565ef66e7dff9f98764da', 'dedda102@gmail.com', 0);
INSERT INTO user(id, username, passwordHash, email, experience)
    VALUES(2, 'test', '098f6bcd4621d373cade4e832627b4f6', 'test@test.com', 0);

-- items

INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-9, 10246, 'Gold Shield', 66048, 0, 10135);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-8, 10654, 'Gold Jacket', 65568, 0, 10321);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-7, 10123, 'Gold Sword', 131076, 10456, 0);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-6, 1246, 'Iron Shield', 66048, 0, 1135);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-5, 1654, 'Iron Jacket', 65568, 0, 1321);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-4, 1123, 'Iron Sword', 131076, 1456, 0);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-3, 246, 'Wooden Shield', 66048, 0, 135);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-2, 654, 'Wooden Jacket', 65568, 0, 321);
INSERT INTO item(id, price, name, types, attack, armor)
    VALUES(-1, 123, 'Wooden Sword', 131076, 456, 0);

-- inventory

INSERT INTO inventory(`user`, id, size)
    VALUES(1, 1, 2);

-- slots

INSERT INTO slot(inventory, item, amount, id)
    VALUES(1, -1, 12, 1);
INSERT INTO slot(inventory, item, amount, id)
    VALUES(1, -4, 2, 2);
