const solution = (numbers, target) => {
    const length = numbers.length;
    let cnt = 0;

    const dfs = (currentNumber, index) => {
        // 정수를 모두 확인했고
        if(index === length) {
            // 타겟 넘버가 만들어졌다면 cnt 1 증가
            if(target === currentNumber) {
                cnt++;
            }
            return;
        }
        // 정수를 더할 경우
        dfs(currentNumber + numbers[index], index + 1);
        // 정수를 뺄 경우
        dfs(currentNumber - numbers[index], index + 1);
    }

    dfs(0, 0)

    return cnt;
}