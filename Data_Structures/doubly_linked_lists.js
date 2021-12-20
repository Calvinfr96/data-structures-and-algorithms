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
console.log(first)

class DoublyLinkedList{
    constrctor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
}