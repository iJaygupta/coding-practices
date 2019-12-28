let dragonArray = [21, 34, 44, 54, 49, 56, 76, 62];

let maxDiff = 0, num1, num2, diff, loc1 , loc2;
for (let i = 0; i < dragonArray.length-1; i++) {
    num1 = dragonArray[i];
    for (let j = i+1; j < dragonArray.length; j++) {
        num2 = dragonArray[j];
        if (num1 < num2) {
            diff = num2 - num1;
        } else {
            diff = num1 - num2;
        }
        console.log("Difference between "+ num1 +" and "+num2+" is "+diff);

        if (diff > maxDiff) {
            maxDiff = diff
        }
    }
}
console.log("Maximum Difference is "+ maxDiff+ "Between ")