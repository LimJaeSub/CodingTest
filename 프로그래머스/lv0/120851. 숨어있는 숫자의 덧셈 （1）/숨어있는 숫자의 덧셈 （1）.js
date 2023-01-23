function solution(my_string) {
    let answer = 0;
    let str = my_string.split("").map(Number);
    for(let i=0;i<str.length;i++){
        if(!isNaN(str[i])){
            answer = answer+str[i];
        }
    }
    
    return answer;
}