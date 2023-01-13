function solution(price) {
  return Math.floor( price>=100000 ? (price>=300000 ? (price>=500000 ? price*0.8 : price*0.9 ) : price*0.95): price)
}
