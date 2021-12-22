class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class Stack {
    constructor() {
        this.first = null;//first to be removed because you're removing from the beginning.
        this.last = null;//last to be removed
        this.size = 0;
    }

    push(value) {
        const node = new Node(value);
        if(!this.first) {
            this.first = node;
            this.last = node;
        } else {
            const first = this.first;
            this.first = node;
            this.first.next = first;
        }
        
        this.size++;
        return this.size;
    }

    pop() {
        if(!this.first) {
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
        return first.value;
    }
}