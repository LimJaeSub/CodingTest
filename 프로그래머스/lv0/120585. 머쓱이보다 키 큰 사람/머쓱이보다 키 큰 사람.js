function solution(array, height) {
    const a = array.filter((it)=>it>height);
    return a.length
}