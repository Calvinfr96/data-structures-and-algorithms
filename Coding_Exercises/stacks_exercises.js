class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Stack {
    constructor() {
        this.first = null;
        this.last = null;
        this.size  = 0;
    }

    push(value) {
        const node = new Node(value);

        if(!this.size) {
            this.first = node;
            this.last = this.first;
        } else {
            const first = this.first;
            this.first = node;
            this.first.next = first;
        }

        this.size++;
        return this.size;
    }

    pop() {
        if(!this.size) {
            return undefined;
        }
        const first = this.first;

        if(this.size === 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
        }

        this.size--;
        return first;
    }
}

//Implementing a Stack With Two Queues
class Queue {
    constructor() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    enqueue(value) {
        const node = new Node(value);

        if(!this.size) {
            this.first = node;
            this.last = this.first;
        } else {
            this.last.next = node;
            this.last = this.last.next;
        }

        this.size++;
        return this.size;
    }

    dequeue() {
        if(!this.size) {
            return undefined;
        }

        const first = this.first;
        if(this.first === this.last) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
        }

        this.size--;
        return first;
    }

    reverse() {
        let previous = null;
        let current = this.first;
        let next = null;
        this.first = this.last;
        this.last = current;

        while(current) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return this;
    }
}

const stack = new Stack();
stack.push("First")
stack.push("Second")
stack.push("Third")
console.log(stack)