function solution(num){
    const mix = num*6;
    for(let i=6;i<=mix;i++){
        if(i%num===0 && i%6===0 ){
            return i/6;
        }
    }
}