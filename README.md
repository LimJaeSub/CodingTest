# CodingTest
------------------------------------------------------------
- 해당 Repository는 코딩테스트 공부를 목적으로 개설하였습니다
----------------------------------------
# List

<details>
  <summary>1. 스택</summary> 
  스택은 데이터를 집어넣을 수 있는 선형 자료형으로 나중에 집어넣은 데이터가 먼저 나오는 LIFO(Last In First Out) 방식의 자료구조입니다.

  - push : 데이터를 집어넣는 동작
  - pop : 데이터를 추출하는 동작
  - peek : 맨 나중에 집어넣은 데이터를 확인하는 동작

  ### Stack in Javascript

  자바스크립트는 array 내장 함수를 통해 스택을 쉽게 구현할 수 있습니다.

  ```javascript
  const stack = [1,2,3,4,5];
  stack.pop(); // 5
  stack.push(10);
  console.log(stack); // [1,2,3,4,10]
```

위 방식을 class로 구현하면 다음과 같습니다

```javascript
class Stack{
	constructor(){
  	this.storage = new Array();
    this.size = 0;
  }
  
  push(element){
  	this.storage[this.size] = element;
    this.size++;
  }
  
  pop(){
  	let lastelement = this.storage[this.size];
    delete this.storage[this.size];
    this.size--;
    return lastelement;
  }
  
  peek(){
   return this.storage[this.size];
  }
}

const stack = new Stack();

stack.push(1);
stack.push("hello");
stack.push(false);

console.log(stack.storage); // [1,"hello",false]
console.log(stack.pop()); // false
console.log(stack.size); // 2
console.log(stack.peek()); // "hello"


```



### 관련 문제
<details>
	<summary>프로그래머스 Lv.2 기능 개발</summary>
	<details>
		<summary>문제 설명</summary>
		문제 설명
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

제한 사항
작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
작업 진도는 100 미만의 자연수입니다.
작업 속도는 100 이하의 자연수입니다.
배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
입출력 예
progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
입출력 예 설명
입출력 예 #1
첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.

따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.

입출력 예 #2
모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다. 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.

따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.

※ 공지 - 2020년 7월 14일 테스트케이스가 추가되었습니다.
	</details>

 - 풀이
```javascript
function solution(progresses, speeds) {
    // progresses : 현재 개발 진척도
    // speeds : 개발 속도
    // 배포는 하루에 한번, 하루의 마지막에 배포하는 느낌
    
    
    let solution = new Array(); // return 값을 담을 배열
    do{
        let finishcount=0; // 배포할 기능의 수, return이 되는 값이다.
        
        // 1. progresses에 각각 speed를 더한다, 모든 과정이 100 이상이 될때까지
        for(let i=0;i<progresses.length;i++){
            progresses[i] = progresses[i]+speeds[i];
        }
        
        let length = progresses.length; // 오늘의 기능 개발 척도가 완료되고 체크할 배열의 길이
        // 내가 쓴 방법은 배열을 줄이는 방법이므로 초기의 배열 길이값을 선언해주었다.
        
        if(progresses[0]>=100){ // 맨 앞의 값이 100 이상일때 == 배포 준비가 완료되었을때    
            for(let j=0;j<length;j++){ 
                if(progresses[j]>=100){ // 개발이 완료된 기능이 있을 경우
                    finishcount++; // 배포할 기능의 수를 증가시켜준다.
                    progresses.shift(); // 배포한 기능은 progresses 배열에서 제외
                    speeds.shift(); // 기능이 빠졌으므로 해당 기능의 진척 속도 speed 또한 제회
                    j--; // 배열이 줄어들었으므로 다음 요소 체크를 위해 for문 기준값 하나 감소
                }
                else{
                    break; // 다음 기능이 개발이 덜 되었을 경우 for문 중단
                }
            }
            solution.push(finishcount); // 배포한 기능의 수 return 배열에 집어넣음
        }
    }while(progresses.length!=0) // 개발할 기능이 하나도 남지 않을때까지 반복
        
    return solution;
    
}
```
</details>
  





</details>
