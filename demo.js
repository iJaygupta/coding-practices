const array = [ 7, -7, 0,-7,  7] ;
let sum =0 ,sub;
let arr=[];
for (let i = 0; i < array.length; i++) {
    sum =sum + array[i];
    arr.push(array[i])
    sub=0
   for (let j = 0; j < i; j++) {
       sub=sub+array[j];
       if(sum==0){
        console.log("sum is zero for array ",arr);
       }
     if(sum-sub==0){
        console.log("sub array sum is zero" , arr.slice(j+1,arr.length));   
    }
 }
}

