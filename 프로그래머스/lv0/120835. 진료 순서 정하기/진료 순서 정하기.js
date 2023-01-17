function solution(emergency) {
    let returnarray = new Array();
    let sortem = emergency.map(Number).sort((a,b)=>{
        return b-a;
    });
    for(let i=0;i<emergency.length;i++){
        returnarray.push(sortem.indexOf(emergency[i])+1);
    }
    
    return returnarray;
}