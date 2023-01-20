function solution(strlist) {
    let returnarray = new Array();
    for(let i=0;i<strlist.length;i++){
        returnarray.push(strlist[i].length);
    }
    
    return returnarray;
}