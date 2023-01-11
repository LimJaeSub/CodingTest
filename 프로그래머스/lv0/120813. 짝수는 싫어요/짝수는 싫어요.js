function solution(num){
    // 홀수 조건 : 2로 나눴을때 나머지가 1 이상인것
    const arr = new Array();
    for(let i=1;i<=num;i++){
        if(i%2>0){
            arr.push(i);
        }
    }
    return arr;
}
