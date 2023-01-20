function fac(num) {
    let returnFactorial = 1
    for(let i = num; i >= 2; i-- ) {
        returnFactorial*=i
    }
    return returnFactorial;
}

function solution(balls, share) {
    let returnnum = 1;
    if(balls==share){
        return 1;
    }
    else{
        if(balls-share>share){
            for(let i=balls;i>balls-share;i--){
                returnnum = returnnum*i;
            }
            return BigInt(returnnum/fac(share));
        }
        else{
            for(let i=balls;i>share;i--){
                returnnum = returnnum*i
            }
            return BigInt(returnnum/fac(balls-share));
        }
    }
}