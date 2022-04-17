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
    }

    pop() {
        if(this.top === null) {
            return undefined;
        }

        const node = this.top;
        this.top = this.top.next;

        return node.value;
    }

    push(value) {
        const node = new Node(value);
        node.next = this.top;
        this.top = node;
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

    peek() {
        if(this.first === null) {
            return undefined;
        }

        return this.first.data;
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

    peak(stack) {
        if(stack > this.numArrays - 1) {
            return `Stack ${stack} does not exist`;
        }
        if(this.start[stack] <= stack*this.capacity) {
            return `Stack ${stack} is empty`;
        }

        return this.values[this.start[stack] - 1];
    }
}

const stack = new ThreeInOne(2,3);
console.log(stack)