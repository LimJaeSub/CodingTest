function solution(array) {
  let map = new Map();
  for (let i = 0; i < array.length; i++) {
    if (map.has(array[i])) {
      // 맵에 해당 데이터가 있으면
      map.set(array[i], map.get(array[i]) + 1); // 해당 키의 밸류값 1 증가
    } else {
      //해당 데이터가 없으면
      map.set(array[i], 1);
    }
  }
  let values = [...map.values()]; // value값의 array
  let keys = [...map.keys()];
  let maxValue = Math.max(...values); // 최댓값

  if (values.filter((it) => it == maxValue).length != 1) {
    // 최댓값을 가진 key가 2개 이상이면
    return -1;
  } else {
    return keys[values.indexOf(maxValue)];
  }
}
