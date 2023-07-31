function solution(n){
    // n을 x로 나눈 나머지가 1이 되도록 하는 x는 가장 작은 자연수
    // n : 10,12
    let arr = new Array();
    for(let i=1;i<n;i++){
        if(n%i===1){
            arr.push(i);
        }
    }
    return arr[0];
}