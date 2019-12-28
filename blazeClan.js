let votes = [ "Eich","A","A","A","A", "Eminem" , "Eminem" , "Eminem" ,"Eich" , "Albert" , "Aarav", "Aarav","Aarav","Albert", "Robert", "Robert", "Albert", "Eich", "Robert" , "Aarav" ,"Eminem" , "Vishal" , "Vishal" , "Akash" , "Akash"  ,"Vishal"];

let obj = {};
let max;

votes.forEach(element => {
    if (obj.hasOwnProperty(element)) {
        obj[element] = obj[element] + 1;
    } else {
        obj[element] = 1;

    }
});

let ordered= Object.keys(obj).sort();
let winner ={}



ordered.map((element)=>{
 winner[element]=obj[element]
})


for (let i =0;i < ordered.length; i++) {
     max = winner[ordered[i]];
    for (let j =1;j < ordered.length; j++)  {
     if(max<winner[ordered[j]]){
       delete winner[ordered[i]]
    
     }
    }
}
for (const iterator in winner) {
    console.log(iterator+" won the election !!")
    return 
    
}













