let number = 48;

function invertNumber(n) {
    let numberStr = n.toString(); // convert string to number
    let invertedStr = numberStr.split('').reverse().join(''); // divide string, reverse that string & 'joins' the numbers
    return parseInt(invertedStr); // convert string to number integer
}

function isCapicua(n) { // 33
    let str = n.toString();
    let invertedStr = str.split('').reverse().join('');
    return str === invertedStr; // 132 === 231 - false
}

function findCapicua(num) { // 48
    let count = 0; // number of iterations

    while (true) {
        let reversedNum = invertNumber(num); // 48 -> 84
        let sum = num + reversedNum; // 132

        count++;

        if (isCapicua(sum)) {
            console.log(sum + " " + count);
            break;
        } else {
            num = sum; // number = 132
        }
    }
}

findCapicua(number);
