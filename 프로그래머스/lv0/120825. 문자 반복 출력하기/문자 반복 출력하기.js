function solution(my_string, n) {
    let joinarr = new Array();
    for(let i=0;i<my_string.length;i++){
        for(let j=0;j<n;j++){
            joinarr.push(my_string[i]);
        }
    }
    
    return joinarr.join("");
}