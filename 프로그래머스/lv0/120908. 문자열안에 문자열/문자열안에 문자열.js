function solution(str1, str2) {
  let answer = str1.split(str2);

  return answer.length>1 ? 1 : 2;
}