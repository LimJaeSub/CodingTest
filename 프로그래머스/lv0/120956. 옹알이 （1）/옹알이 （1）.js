function check(str){
    let checkarr = Array.from(str.replace(/aya|ye|woo|ma/g,1)).map(Number);
    for(let i=0;i<checkarr.length;i++){
        if(isNaN(checkarr[i])){
            return false;
        }
    }
    
    return true;
}
function solution(babbling) {
    let count=0;
    for(let i=0;i<babbling.length;i++){
        if(check(babbling[i])){
            count++;
        }
    }
    
    return count;
}