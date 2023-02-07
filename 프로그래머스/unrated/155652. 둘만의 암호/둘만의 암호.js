function solution(s, skip, index) {
    var answer = '';
    let sArr = [];
    let skipArr = [];
    
    // 알파벳 to 아스키코드 
    for (let i = 0; i < s.length; i++) {
        sArr.push(s.charCodeAt(i) % 97)
    }
    
    // 알파벳 to 아스키코드 
     for (let i = 0; i < skip.length; i++) {
        skipArr.push(skip.charCodeAt(i) % 97)
    }
    
    
    for (let i = 0; i < sArr.length; i++) {
        for (let k = 0; k < index; k++) {
            do {
                sArr[i]++;  
                if (sArr[i] == 26) sArr[i] = 0;
            } while (skipArr.includes(sArr[i])); // skip에 등록된 단어인 경우 계속 반복  
        }
        answer += String.fromCharCode(sArr[i] + 97);
    }
    
    
    return answer;
}