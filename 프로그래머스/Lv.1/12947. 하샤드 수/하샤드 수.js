function solution(x) {
    let strnum = x.toString().split("").map(Number);
    
    // 1. 자릿수 합
    let numsum = strnum.reduce((acc,cur)=>{
   return acc=acc+cur     
    },0)
    
    // 2. 원본 수%자릿수 합 == 0일경우 true 아니면 false
    return x%numsum==0 ? true : false
    
}