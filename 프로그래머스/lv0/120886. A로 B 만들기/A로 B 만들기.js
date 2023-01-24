function solution(before, after) {
    before = Array.from(before).sort().join("");
    after = Array.from(after).sort().join("");
    
    return before==after ? 1 : 0;
}