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
}