function solution(array, n) {
    let array2 = array.map((it)=>Math.abs(it-n));
    let minabs = Math.min(...array2);
    let answerindex = new Array();
    for(let i=0;i<array2.length;i++){
        if(array2[i]==minabs){
            answerindex.push(array[i]);
        }
    }
    
    
    return Math.min(...answerindex);
    
}