function solution(num, k) {
    let result = Array.from(String(num)).indexOf(String(k));
    return result===-1?result : result+1;
}