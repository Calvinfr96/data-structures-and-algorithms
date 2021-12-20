class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
}

//Example Node Objects:
const first = new Node(1);
first.next = new Node(2);
first.next.previous = first;

class DoublyLinkedList{
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    push(value) {
        const node = new Node(value);

        if(!this.head) {
            this.head = node;
            this.tail = node;
            this.length++;
        } else {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
            this.length++;
        }

        return this;
    }

    pop() {
        if(!this.head) {
            return undefined;
        }
        
        const tail = this.tail;
        if(!this.head.next) {
            this.head = null;
            this.tail = null;
        } else {
            const tail = this.tail;
            this.tail = tail.previous;
            tail.previous = null;
            this.tail.next = null;
        }
        this.length--;
        return tail;
    }
}

const list = new DoublyLinkedList();