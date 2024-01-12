function solution(a, b) {
    let inputarray = [a,b].sort((a,b)=>{
        return a-b;
    })
    
    let sum=0
    for(let i=inputarray[0];i<=inputarray[1];i++){
        sum=sum+i;
    }
    return sum;
}