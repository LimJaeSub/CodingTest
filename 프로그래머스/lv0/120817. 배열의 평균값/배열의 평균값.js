function solution(numbers) {
    const num = numbers.reduce((acc,cur)=>{
        return acc+cur
    },0)
    
    return num/numbers.length;
}