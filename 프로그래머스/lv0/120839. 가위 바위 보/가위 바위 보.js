function solution(rsp) {
    //2 = 0,0 = 5,5 = 2
    const win = {
        "2":"0",
        "0":"5",
        "5":"2"
    }
    let answer="";
    for(let i=0;i<rsp.length;i++){
        answer+=win[rsp[i]];
    }
    
    return answer;
}