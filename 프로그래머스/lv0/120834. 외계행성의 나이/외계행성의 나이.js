function solution(age) {
    let alpha = 'abcdefghij';
    let strage = age.toString();
    let returnarray = new Array();
    for(let i=0;i<strage.length;i++){
        returnarray.push(alpha[Number(strage[i])]);
    }
    
    return returnarray.join("");
}