function solution(s) {
    let splitstr = s.split(" ").map(Number);
    let maxnum = Math.max(...splitstr);
    let minnum = Math.min(...splitstr);
    
    return `${minnum} ${maxnum}`;

}