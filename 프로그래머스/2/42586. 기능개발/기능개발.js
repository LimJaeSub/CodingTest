function solution(progresses, speeds) {
    let checknum=0;
    let solution = new Array();
    do{
        let finishcount=0;
        checknum=0;
        for(let i=0;i<progresses.length;i++){
            progresses[i] = progresses[i]+speeds[i];
            // if(progresses[i]>=100){
            //     checknum++;
            // }
        }
        //console.log(checknum);
        let length = progresses.length;
        if(progresses[0]>=100){
            
            for(let j=0;j<length;j++){
                if(progresses[j]>=100){
                    finishcount++;
                    progresses.shift();
                    speeds.shift();
                    j--;
                }
                else{
                    break;
                }
            }
            solution.push(finishcount);
        }
    }while(progresses.length!=0)
        
    return solution;
}