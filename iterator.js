const dragonArray = [11, 43, 65, 87, 90]
var counter = -1;

function checkDragon(dragonArray) {
   counter++;
   return {
      next: function () {
       if(counter==dragonArray.length){
          return {
             value :undefined,
             done :true
          }
       }else{
          return {
             value:dragonArray[counter],
             done : false
          }
       }
      }
   }
}


let iterator = checkDragon(dragonArray);
console.dir(iterator.next());
