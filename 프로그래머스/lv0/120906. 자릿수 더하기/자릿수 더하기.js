function solution(n) {
  let str = n.toString().split("").map(Number);
  return str.reduce((acc, cur) => {
    return (acc = acc + cur);
  }, 0);
}