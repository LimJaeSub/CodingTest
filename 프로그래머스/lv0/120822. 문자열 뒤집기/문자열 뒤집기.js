function solution(my_string) {
    let joinarr = new Array();
    for(let i=my_string.length-1;i>=0;i--){
        joinarr.push(my_string[i]);
    }
    
    return joinarr.join("");
}