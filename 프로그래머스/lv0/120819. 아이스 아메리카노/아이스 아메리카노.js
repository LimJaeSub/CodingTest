function solution(money) {
    const pay = Math.floor(money/5500);
    return [pay,money-pay*5500]
}