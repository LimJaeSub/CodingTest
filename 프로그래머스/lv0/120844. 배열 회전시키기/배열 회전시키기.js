function solution(numbers, direction) {
    if(direction=="right"){
        const pop = numbers.pop();
        numbers.unshift(pop);
    }
    else{
        const front = numbers.shift();
        numbers.push(front);
    }
    return numbers;
}