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
            this.tail = tail.previous;
            tail.previous = null;
            this.tail.next = null;
        }
        this.length--;
        return tail;
    }

    shift() {
        if(!this.head) {
            return undefined;
        }

        const head = this.head;
        if(!this.head.next) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            head.next = null;
            this.head.previous = null;
        }
        this.length--;

        return head;
    }

    unshift(value) {
        const newNode = new Node(value);

        if(!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.length++;

        return this;
    }

    get(index) {
        if(index < 0 || index >= this.length) {
            return undefined;
        } else {
            const middle = Math.floor(this.length / 2);
            let node;
            index >= middle ? node = this.tail : node = this.head;
            if(index >= middle) {
                for(let i = this.length - 1; i > index; i--) {
                    node = node.previous;
                }
            } else {
                for(let i = 0; i < index; i++) {
                    node = node.next;
                }
            }
            return node;
        }
    }

    set(index, value) {
        const node = this.get(index);
        if(node) {
            node.value = value;
            return true;
        } else {
            return false;
        }
    }
}

const list = new DoublyLinkedList();