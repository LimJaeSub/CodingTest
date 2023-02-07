function findnum(num) {
  let count = 0;
  if (num == 1) {
    return 1;
  }
  for (let i = 1; i < Math.sqrt(num); i++) {
    if (num % i == 0) {
      count++;
    }
  }
  return Number.isInteger(Math.sqrt(num)) ? count * 2 + 1 : count*2;
}

function solution(number, limit, power) {
    let sum=0;
    for(let i=1;i<=number;i++){
        if(findnum(i)>limit){
            sum=sum+power;
        }
        else{
            sum=sum+findnum(i);
        }
    }
    
    return sum;
    
}