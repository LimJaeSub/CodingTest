function check(num){
    for(let i=2;i<=Math.sqrt(num);i++){
        if(num%i===0){
            return true;
        }
    }
    return false;
}
function solution(n) {
    let count=0;
    for(let i=1;i<=n;i++){
        if(check(i)){
            count++;
        }
    }
    return count;
}