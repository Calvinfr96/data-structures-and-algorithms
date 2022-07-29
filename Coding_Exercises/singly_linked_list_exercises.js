class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SinglyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    get(index) {
        if(index < 0 || index >= this.length) {
            return null;
        } else if(index === 0) {
            return this.head;
        } else if(index === this.length - 1) {
            return this.tail;
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
            node.value = value;
            return true;
        } else {
            return false;
        }
    }

    push(value) {
        const node = new Node(value);

        if(!this.length) {
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
        if(!this.length) {
            return undefined;
        }

        const tail = this.tail;
        if(this.length === 1) {
            this.head = null;
            this.tail = null;
        } else if(this.length === 2) {
            this.head.next = null;
            this.tail = this.head;
        } else {
            const newTail = this.get(this.length - 2);
            newTail.next = null;
            this.tail = newTail;
        }

        this.length--;
        return tail;
    }

    shift() {
        if(!this.length) {
            return undefined;
        }

        const head = this.head;
        if(this.length === 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }

        this.length--;
        return head;
    }

    unshift(value) {
        const node = new Node(value);

        if(!this.length) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }

        this.length++;
        return this;
    }

    insert(index, value) {
        if(index < 0 || index > this.length) {
            return false;
        } else if(index === 0) {
            return !!this.unshift(value);
        } else if(index === this.length) {
            return !!this.push(value);
        } else {
            const node = new Node(value);
            const previousNode = this.get(index - 1);
            const nextNode = this.get(index);
            previousNode.next = node;
            node.next = nextNode;

            this.length++;
            return true;
        }
    }

    remove(index) {
        if(index < 0 || index >= this.length) {
            return undefined;
        } else if(index === 0)  {
            return this.shift();
        } else if(index === this.length - 1) {
            return this.pop();
        } else {
            const node = this.get(index);
            const previousNode = this.get(index - 1);
            const afterNode = this.get(index + 1);
            previousNode.next = afterNode;

            this.length--;
            return node;
        }
    }

    rotate(index) {
        //Problem: Write a function that accepts an index and "rotates" a singly linked list at that index, then returns the list.
        //Example: If your list looks like 1->2->3->4->5 and you rotate at 2, the list becomes 3->4->5->1->2 
        //Breakdown:
        // Step 1: The index passed to the function becomes the new head, so if an index of 0 is passed, simply return the list.
        // Step 2: Save the node at the desired index in a variable called current.
        // Step 3: Save the node after current in a variable called nextNode.
        // Step 4: Set the next property of current to be null.
        // Step 5: Set the next property of the tail to be the head.
        // Step 6: Set the tail to be current.

        //Solution:
        if(index < 0 || index >= this.length) {
            return undefined;
        } else if(index === 0) {
            return this;
        } else {
            const current = this.get(index - 1);
            const nextNode = this.get(index);
            current.next = null;
            this.tail.next = this.head;
            this.tail = current;
            this.head = nextNode;

            return this;
        }
    }
}

const list = new SinglyLinkedList();
list.push(5)
list.push(10)
list.push(15)
list.push(20)
list.push(25)
console.log(list.rotate(4))
console.log(list)
console.log(list.head.value)
console.log(list.head.next.value)
console.log(list.head.next.next.value)
console.log(list.head.next.next.next.value)
console.log(list.head.next.next.next.next.value)
console.log(list.tail.value)
console.log(list.tail.next)