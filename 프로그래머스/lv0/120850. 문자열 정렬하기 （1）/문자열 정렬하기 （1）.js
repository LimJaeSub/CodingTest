function solution(my_string) {
    return Array.from(my_string).map(Number).filter((it)=>!isNaN(it)).sort((a,b)=>a-b);
}