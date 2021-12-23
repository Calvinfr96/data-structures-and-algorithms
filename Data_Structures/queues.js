class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Queue {
    constructor() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    enqueue(value) {
        const node  = new Node(value);
        if(!this.first) {
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            this.last = this.last.next;
        }

        this.size++;
        return this.size;
    }

    dequeue() {
        if(!this.first) {
            return undefined;
        }

        const first = this.first;
        if(!this.first.next) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
        }

        this.size--;
        return first.value;
    }
}