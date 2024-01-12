function solution(absolutes, signs) {
   signs = signs.map((it)=>{
       return it===true?'':'-';
   }) 
    
    absolutes = absolutes.map((it,idx)=>{
        return Number(`${signs[idx]}${it}`);
    })
    
    return absolutes.reduce((acc,cur)=>{
        return acc=acc+cur
    },0)
}