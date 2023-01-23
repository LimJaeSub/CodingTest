function solution(n) {
    let mod=1;
    let result = 1;
    while(true){
        mod = mod*result;
        if(mod>n){
            result--;
            break;
        }
        else if(mod==n){
            break;
        }
        result++;
    }
    
    return result;
}