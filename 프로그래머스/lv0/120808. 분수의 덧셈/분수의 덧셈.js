function solution(number1, denom1, number2, denom2) {
    // 분자
    let topNum = number1*denom2 + number2*denom1;
    // 분모
    let botNum = denom1*denom2;
    // 최소 공배수
    let maximum = 1
    // 약분
    for(let i = 1 ; i <= topNum ; i ++) {
        if(topNum%i === 0 && botNum%i === 0) {
            maximum = i
        }
    }
    return [topNum/maximum, botNum/maximum]
}