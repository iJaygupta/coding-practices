
// const cars = [
//     { make: "toyota", color: "red", cat: "suv" },
//     { make: "honda", color: "black", cat: "sedan" },
//     { make: "toyota", color: "red", cat: "sedan" },
//     { make: "nissan", color: "blue", cat: "suv" },
//     { make: "toyota", color: "red", cat: "suv" },
//     { make: "honda", color: "black", cat: "sedan" },
//     { make: "toyota", color: "red", cat: "sedan" },
//     { make: "nissan", color: "blue", cat: "suv" },
//     { make: "toyota", color: "red", cat: "suv" },
//     { make: "honda", color: "black", cat: "sedan" },
//     { make: "toyota", color: "red", cat: "sedan" },
//     { make: "nissan", color: "blue", cat: "suv" },
//     { make: "toyota", color: "red", cat: "suv" },
//     { make: "honda", color: "black", cat: "sedan" },
//     { make: "toyota", color: "red", cat: "sedan" },
//     { make: "nissan", color: "blue", cat: "suv" },
//     { make: "toyota", color: "red", cat: "suv" },
//     { make: "honda", color: "black", cat: "sedan" },
//     { make: "toyota", color: "red", cat: "sedan" },
//     { make: "nissan", color: "blue", cat: "suv" },
//     { make: "toyota", color: "red", cat: "suv" },
//     { make: "honda", color: "black", cat: "sedan" },
//     { make: "toyota", color: "red", cat: "sedan" },
//     { make: "nissan", color: "blue", cat: "suv" },
//     { make: "toyota", color: "red", cat: "suv" },
//     { make: "honda", color: "black", cat: "sedan" },
//     { make: "toyota", color: "red", cat: "sedan" },
//     { make: "nissan", color: "blue", cat: "suv" },
// ];







// function dogs(name, age, gender){

//    this.name = name;
//    this.age = age;
//    this.gender = gender;
//    return (`my ${name} is ${age} years old and its  ${gender}`)
// }
// const dis= dogs("kutta", "4", "male");
// console.log( dis);



// function calculateBill( total, tax, tip){
// tax= tax || .15;
// tip= tip || .25;
//    return total + (total * tax) + (total * tip)

// }
// const totalBill = calculateBill(100, undefined ,.50,);
// console.log(totalBill)




const race = "100m dash";
const winners = [23, 3, 8];

// const win = winners.map((kuchbhi) => (

//    { name: kuchbhi, race, place: 1 }
// ))
//    console.log(win)


var win = winners.forEach((winner) => {return winner})

console.log(win);




// const ages = [40, 50, 86, 78, 72, 76, 75];

// const older = ages.filter( age => age >= 45);

// console.log(older);




// const names = ['harsh', 'jay', 'sachin'];
// const fullNames = names.map(function(name){
// return `${name} boss`;

// })

// const fullNames2 = names.map( ( name ) => { 
// return `${name} boss`;

//  })


//  const fullNames3 = names.map( name  => { 
//     return `${name} boss`;
//  })

//  const fullNames4 = names.map( name  => `${name} boss`);

//  const fullNames5 = names.map( ()  => `cool boss`);

// console.log(fullNames5)




// for (const key in cars) {
//     if (cars[key].color == "red") {
//         cars[key].color = "violet"
//     }
// }
// console.log(cars);

// for(let i =0; i< cars.length; i++)
// {
//     if(cars[i].make == "honda")
//     console.log(cars[i].color)
// }




// cars.forEach((harsh) => {

//         if (harsh.make =="honda") 
//             console.log(harsh.color)


//     })







// const car = [
//     { "id": "1", "color": "red"},
//     { "id": "2", "color": "black"},
//     { "id": "3", "color": "red"}]


// for (let i = 0; i < cars.length; i++) {
//     console.log(cars[i].make);
// }



// console.log("here");



// console.log("Done");

// exports.myfunc = function () {
//     cars.forEach((elem) => {
//         console.log("IN Middle");
//     })
// }

// cars.forEach(elem => console.log(elem));


// for (const iterator of cars) {
//     console.log(iterator);
// }


// let colors = cars.map(elem => elem.color);

// let selected = cars.filter(data => data.color == "red")


// for (const key in cars) {
//     console.log(key)

    // console.log(cars[key])
// }


// let here = cars.filter(function (data) {
//     return (data.color == "red" || data.cat == "sedan")
// })


// let str = "iamheman"
// let here = "hemaniam"



// for (let i = 0; i < str.length; i++) {
//     let temp = str.charAt(0);
//     str = str.replace(temp, '')
//     str = str.concat(temp)
//     if (str == here) {
//         console.log(`${str} is found if rotated`);
//     }
// }




// let a = ""
// let b = a == " " ? 0 : 10
// console.log(b)
