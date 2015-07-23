var filename = 'storeTest.js';
print(filename);

if (store.getClass().getCanonicalName() !== 'scheisse.game_ai.Store') {
    fail();
    errorMessages.push(new Error().lineNumber + ": Store not defined!");
}

if (store.getUser().getClass().getCanonicalName() !== 'org.dedda.games.scheisse.entity.User') {
    fail();
    errorMessages.push(new Error().lineNumber + ": User not defined!");
}
