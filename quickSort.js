// module.exports = {
//     fibonacci: function () {
//         let a = 0, b = 1, c = 0;
//         while (c <= 13) {
//             console.log(c);
//             a = b;
//             b = c;
//             c = a + b;
//         }
//         return null;
//     },
//     timer: function () {
//         setTimeout(() => {
//           console.log("2");
//         }, 200)
//         console.log("1")

//     }

// }

// let imp = require("./quickSort");
// // console.log(imp.fibonacci());
// imp.timer();

// console.log("first");
// setTimeout(()=>{
//   console.log("second");
// },100)

// console.log("third");


// console.log(process.env);


let arr = [2, 3, 4, 3, 5, 6, 7, 2]

let obj = {
}

for (let i = 0; i < arr.length; i++) {
  obj[arr[i]] = true;
}

console.log(Object.keys(obj))
