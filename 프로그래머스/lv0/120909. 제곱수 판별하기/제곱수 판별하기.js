function solution(n) {
    let root = Math.sqrt(n);
    return Number.isInteger(root) ? 1 : 2;
}