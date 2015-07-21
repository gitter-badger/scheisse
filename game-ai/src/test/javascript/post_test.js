if (!success) {
    if (typeof filename !== 'undefined') {
        print(filename + ' has failures!');
    } else {
        print('failures!');
    }
    var i = 0;
    while (i++ < errorMessages.length - 1) {
        print("Error: " + errorMessages[i]);
    }
}
