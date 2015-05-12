USE `scheisse`;

-- users

INSERT INTO user(id, username, passwordHash, email, experience)
    VALUES(1, 'dedda', 'cfcd208495d565ef66e7dff9f98764da', 'dedda102@gmail.com', 0);
INSERT INTO user(id, username, passwordHash, email, experience)
    VALUES(2, 'test', '098f6bcd4621d373cade4e832627b4f6', 'test@test.com', 0);

-- items

INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-9, 10246, 'Gold Shield', 'SHIELD', 0, 10135, 9);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-8, 10654, 'Gold Armor', 'ARMOR', 0, 10321, 8);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-7, 10123, 'Gold Sword', 'WEAPON', 10456, 0, 7);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-6, 1246, 'Iron Shield', 'SHIELD', 0, 1135, 6);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-5, 1654, 'Iron Armor', 'ARMOR', 0, 1321, 5);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-4, 1123, 'Iron Sword', 'WEAPON', 1456, 0, 4);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-3, 246, 'Wooden Shield', 'SHIELD', 0, 135, 3);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-2, 654, 'Wooden Armor', 'ARMOR', 0, 321, 2);
INSERT INTO item(id, price, name, type, attack, armor, stock)
    VALUES(-1, 123, 'Wooden Sword', 'WEAPON', 456, 0, 1);

-- inventory

INSERT INTO inventory(`user`, id, size)
    VALUES(1, 1, 2);

-- slots

INSERT INTO slot(inventory, item, amount, id)
    VALUES(1, -1, 12, 1);
INSERT INTO slot(inventory, item, amount, id)
    VALUES(1, -4, 2, 2);
