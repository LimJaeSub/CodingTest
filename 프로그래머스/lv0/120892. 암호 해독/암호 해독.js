function solution(cipher, code) {
    return Array.from(cipher).filter((it,index)=>(index+1)%code==0).join("");
}