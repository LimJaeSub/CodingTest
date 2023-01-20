function solution(sides) {
    const max = Math.max(...sides);
    const other = sides.filter((it)=>it!=max);
    
    return other[0]+other[1]<=max ? 2 : 1;
}