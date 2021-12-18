class Node {
    constructor(val) {
        this.val = val
        this.next = null
    }
}

//Example Node Objects
const first = new Node('Head');
first.next = new Node('Node 2');
first.next.next = new Node('Node 3');
first.next.next = new Node('Node 4');
first.next.next.next = new Node('Node 5');

class SinglyLinkedList {
    constructor() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    push(value) {
        const node = new Node(value);

        if(!this.head) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.length++;
        return this;
    }

    pop() {
        if(!this.head) {
            return undefined;
        } else if(this.head === this.tail) {
            const tail = this.head;
            this.head = null;
            this.tail = null;
            this.length--;
            return tail;
        } else {
            const tail = this.tail;
            let prev = this.head;
            while(prev.next !== this.tail) {
                prev = prev.next
            }
            prev.next = null;
            this.tail = prev;
            this.length--;
            return tail;
        }
    }

    shift() {
        if(!this.head) {
            return undefined;
        } else if(this.head === this.tail) {
            const head = this.head;
            this.head = head.next;
            this.tail = null;
            this.length--;
            return head;
        } else {
            const head = this.head;
            this.head = head.next;
            this.length--;
            return head;
        }
    }

    unshift(value) {
        const node = new Node(value);

        if(!this.head) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.length++;
        return this;
    }
    
    get(index) {
        if(index < 0 || index >= this.length) {
            return undefined;
        } else {
            let node = this.head;
            for(let i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

    set(index, value) {
        const node = this.get(index);
        if(node) {
            node.val = value;
            return true;
        } else {
            return false;
        }
    }
}