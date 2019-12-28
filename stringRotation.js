let str = "geeksforgeeks"
let here = "geeksgeeksfor"

for (let i = 0; i < str.length; i++) {
    let temp = str.charAt(0);
    str = str.replace(temp, '')
    str = str.concat(temp)
    if (str == here) {
        console.log(`${str} is found if rotated`);
    }
}
