# CodingTest
------------------------------------------------------------
- 해당 Repository는 코딩테스트 공부를 목적으로 개설하였습니다
----------------------------------------
# List

<details>
  <summary>1. 스택&큐</summary> 

 ### 스택
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

### 큐

큐(Queue)는 데이터를 집어넣을 수 있는 선형 자료형으로 스택과는 다르게 먼저 집어넣은 자료가 먼저 나옵니다. (FIFO - First in First Out)

- enqueue : 데이터를 집어넣는 동작
- dequeue : 데이터를 추출하는 동작

### Queue in Javascript

큐를 클래스로 구현하면 다음과 같습니다

```javascript
class Queue{
	constructor(){
  	this.storage = new Array();
  }
  
  enqueue(element){
  	this.storage.push(element);
  }
  
  dequeue(){
  	this.storage.shift();
  }
}
```

----------------------------

### 관련 문제
<details>
	<summary>프로그래머스 Lv.2 기능 개발</summary>
	- 문제 및 답안 링크 : https://github.com/LimJaeSub/CodingTest/tree/main/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4/2/42586.%E2%80%85%EA%B8%B0%EB%8A%A5%EA%B0%9C%EB%B0%9C
	
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
