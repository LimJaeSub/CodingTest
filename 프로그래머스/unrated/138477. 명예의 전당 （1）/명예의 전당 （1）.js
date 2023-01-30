function solution(k, score) {
    let stack = new Array();
    let i=0;
    let returnarray = new Array();
    while(i<score.length){
        if(stack.length<k){
            stack.push(score[i]);
        }
        else if(stack.length===k){
            let min = Math.min(...stack);
            if(score[i]>min){
                stack.splice(stack.indexOf(min),1,score[i]);
            }
        }
        returnarray.push(Math.min(...stack));
        i=i+1;
    }
    
    return returnarray;
}