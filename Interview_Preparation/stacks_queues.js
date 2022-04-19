//Implementing a Stack
class Node {
    constructor(value) {
        this.value = value;
        this.next = null
    }
}

class Stack {
    constructor() {
        this.top = null;
        this.size = 0;
    }

    pop() {
        if(this.top === null) {
            return undefined;
        }

        const node = this.top;
        this.top = this.top.next;
        this.size--;

        return node.value;
    }

    push(value) {
        const node = new Node(value);
        node.next = this.top;
        this.top = node;
        this.size++;

        return this.size;
    }

    peek() {
        if(this.top === null) {
            return undefined;
        }

        return this.top.value;
    }

    isEmpty() {
        return this.top === null;
    }
}

//Implementing a Queue
class Queue {
    constructor() {
        this.first = null;
        this.last = null;
    }

    add(value) {
        const node = new Node(value);

        if(this.last !== null) {
            this.last.next = node;
        }
        this.last = node;

        if(this.first === null) {
            this.first = this.last
        }
    }

    remove() {
        if(this.first === null) {
            return undefined;
        }

        const node = this.first;
        this.first = this.first.next;

        if(this.first === null) {
            this.last = null
        }

        return node.value;
    }

    peek() {
        if(this.first === null) {
            return undefined;
        }

        return this.first.value;
    }

    isEmpty() {
        return this.first === null;
    }
}


//Question 3.1 - Three in One
class ThreeInOne {
    constructor(capacity, numArrays) {
        this.capacity = capacity;
        this.numArrays = numArrays;
        this.values = Array(capacity*numArrays);

        this.start = []
        for(let i = 0; i < numArrays; i++) {
            this.start.push(i*capacity )
        }

        this.end = []
        for(let i = 1; i <= numArrays; i++) {
            this.end.push(i*capacity)
        }
    }

    push(stack, value) {
        if(stack > this.numArrays - 1) {
            return `Stack ${stack} does not exist`;
        }
        if(this.start[stack] >= this.end[stack]) {
            return `Stack ${stack} is full`;
        }

        this.values[this.start[stack]] = value;
        this.start[stack] += 1;

        return this.start;
    }

    pop(stack) {
        if(stack > this.numArrays - 1) {
            return `Stack ${stack} does not exist`;
        }
        if(this.start[stack] <= stack*this.capacity) {
            return `Stack ${stack} is empty`;
        }

        const value = this.values[this.start[stack] - 1];
        this.values[this.start[stack] - 1] = null;
        this.start[stack] -= 1;

        return value;
    }

    peek(stack) {
        if(stack > this.numArrays - 1) {
            return `Stack ${stack} does not exist`;
        }
        if(this.start[stack] <= stack*this.capacity) {
            return `Stack ${stack} is empty`;
        }

        return this.values[this.start[stack] - 1];
    }
}

//Question 3.2 - Stack Min
class MinStack {
    constructor() {
        this.stack = new Stack();
        this.minimums = new Stack();
    }

    push(value) {
        if(this.minimums.isEmpty() || value < this.minimums.peek()) {
            this.minimums.push(value);
        }
        this.stack.push(value);
    }
    
    pop() {
        if(this.stack.peek() === this.minimums.peek()) {
            this.minimums.pop();
        }
        this.stack.pop();
    }

    top() {
        return this.stack.peek();
    }

    getMin() {
        return this.minimums.peek();
    }
}

//Question 3.2A - Min Stack 2
class MinNode {
    constructor(value) {
        this.value = value
        this.next = null;
        this.minimum = 0;
    }
}

class MinNodeStack {
    constructor() {
        this.top = null;
    }

    push(value) {
        const node = new MinNode(value);
        node.next = this.top;
        this.top = node;

        if(this.top === null) {
            node.minimum = node.value;
        }
        if(node.value < node.next.minimum) {
            node.minimum = node.value;
        }
        node.minimum = node.next.minimum;

        return node.value;
    }

    pop() {
        if(this.top === null) {
            return undefined;
        }

        const top =  this.top;
        this.top = this.top.next;

        return top.value;
    }

    getMin() {
        return this.top.minimum;
    }
}

//Question 3.3 - Set of Stacks
class setOfStacks {
    constructor() {
        this.stacks = [];
        this.capacity = 2;
    }

    push(value) {
        if(this.isEmpty() || this.stackFull()) {
            console.log("Pushing...")
            this.stacks.push(new Stack())
        }

        return this.stacks[this.stacks.length - 1].push(value)
    }

    isEmpty() {
        return this.stacks.length === 0;
    }

    stackFull() {
        if(this.isEmpty()) {
            return false;
        }

        return this.stacks[this.stacks.length - 1].size === this.capacity;
    }
}

//Question 3.4 - Queue With Two Stacks
class StacksQueue {
    // The oldestOnTop represents the actual queue and the newestOnTop represents items waiting to be added to the queue. When the queue is emptied, everyone waiting to be added to the queue will be added.
    constructor() {
        this.newestOnTop = new Stack();
        this.oldestOnTop = new Stack();
    }

    equeue(value) {
        this.newestOnTop.push(value)
    }

    peak() {
        this.shiftStacks();
        return this.oldestOnTop.peek();
    }

    dequeue() {
        this.shiftStacks();
        return this.oldestOnTop.pop();
    }

    shiftStacks() {
        if(this.oldestOnTop.isEmpty()) {
            while(!this.newestOnTop.isEmpty()) {
                this.oldestOnTop.push(this.newestOnTop.pop())
            }
        }
    }
}

function sortStack(stack) {
    const sortedStack = new Stack();
    let max = findMax(stack, Infinity);

    while(max > -Infinity) {
        sortedStack.push(max)
        max = findMax(stack, max)
    }

    return sortedStack;
}

function findMax(stack, maximum) {
    let node = stack.top;
    let currentMaximum = -Infinity;

    while(node) {
        if(node.value < maximum) {
            if(node.value > currentMaximum) {
                currentMaximum = node.value;
            }
        }

        node = node.next
    }

    return currentMaximum;
}

//Question 3.6 - Animal Shelter
class AnimalShelter {
    constructor() {
        this.dogQueue = new Queue();
        this.catQueue = new Queue();
    }

    enqueue(animal) {
        if(animal === "dog") {
            this.dogQueue.enqueue(animal)
        } else {
            this.catQueue.enqueue(animal)
        }
    }

    adopt(animal) {
        if(animal === "dog") {
            this.dogQueue.dequeue()
        } else {
            this.catQueue.dequeue()
        }
    }

    adoptAny() {
        const random = this.getRandomInt(1,100)

        if(random % 2 === 0) {
            this.dogQueue.dequeue();
        } else {
            this.catQueue.dequeue()
        }
    }

    getRandomInt(min, max) {
        return Math.floor(Math.random()*(max - min) + min)
    }
}