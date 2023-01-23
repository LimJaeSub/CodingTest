function solution(n) {
    let array = new Array();
    for(let i=1;i<=Math.floor(n/2);i++){
        if(n%i==0){
            array.push(i);
        }
    }
    array.push(n);
    return array;
}