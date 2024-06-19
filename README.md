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





</details>
