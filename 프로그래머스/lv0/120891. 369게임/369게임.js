function solution(order) {
    return Array.from(String(order)).map(Number).filter((it)=>(it==3)||(it==6)||(it==9)).length;
}