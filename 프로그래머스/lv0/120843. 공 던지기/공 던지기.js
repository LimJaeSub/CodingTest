class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = null;
  }
  enqueue(newvalue) {
    const newNode = new Node(newvalue);
    if (this.head === null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }
  dequeue() {
    const value = this.head.value;
    this.head = this.head.next;
    this.enqueue(value);
  }
  peek() {
    return this.head.value;
  }
}

function solution(numbers, k) {
  const que = new Queue();
  for (let i = 0; i < numbers.length; i++) {
    que.enqueue(numbers[i]);
  }
  for (let i = 1; i < k; i++) {
    que.dequeue();
    que.dequeue();
    //console.log(que.peek());
  }

  return que.peek();
}

console.log(solution([1, 2, 3, 4, 5, 6], 5));