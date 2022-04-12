// Singly Linked Lists

class Node {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SingleLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    get(index) {
        if(index < 0 || index > this.length - 1) {
            return undefined;
        } else if(index === 0) {
            return this.head;
        } else if(index === this.legnth - 1) {
            return this.tail;
        } else {
            let node = this.head;
            for(let i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
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
        return this.length;
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
        return this.length;
    }

    pop() {
        const tail = this.tail;
        if(this.length === 0) {
            return undefined;
        } else if(this.length === 1) {
            this.tail = null;
            this.head = this.tail;
        } else {
            let node = this.get(this.length - 2);
            node.next = null
            this.tail = node;
        }

        this.length--;
        return tail;
    }

    shift() {
        const head = this.head;
        if(this.length === 0) {
            return undefined;
        } else if(this.length === 1) {
            this.head = null;
            this.tail = this.head;
        } else {
            this.head = this.head.next;
            head.next = null;
        }

        this.length--;
        return head;
    }

    insert(value, index) {
        if(index < 0 || index > this.length) {
            return undefined;
        } else if(index === 0) {
            return this.unshift(value);
        } else if(index === this.length) {
            return this.push(value);
        } else {
            const node = new Node(value);
            const previous = this.get(index - 1);
            const next = this.get(index);

            previous.next = node;
            node.next = next;

            this.length++;
            return this.length;
        }
    }

    remove(index) {
        if(index < 0 || index > this.length - 1) {
            return undefined;
        } else if(index === 0) {
            return this.shift();
        } else if(index === this.length - 1) {
            return this.pop();
        } else {
            const node = this.get(index);
            const previous = this.get(index - 1);
            const next = this.get(index + 1);

            previous.next = next;
            node.next = null;

            this.length--;
            return node;
        }
    }

    reverse() {
        if(this.length === 1) {
            return this;
        }

        let previous = null;
        let current = this.head;
        let next = null;

        while(current) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        const head = this.head;
        this.head = this.tail;
        this.tail = head;

        return this;
    }
}

//Question 2.1
function removeDuplicates(list) {
    const uniqueVals = {};
    const result = new SingleLinkedList();

    let node = list.head;
    for(let i = 0; i < list.length; i++) {
        uniqueVals[node.value] || (uniqueVals[node.value] = 1);
        node = node.next;
    }
    for(let key in uniqueVals) {
        result.push(key);
    }

    return result;
}

//Question 2.2 - 
function kthToLast(list, index) {
    return list.get(list.length - (index));
}

//Question 2.3 - 
function deleteMiddleNode(list, node){
    let index = 0;

    while(node.next) {
        index++;
        node = node.next;
    }

    list.remove(list.length - (index + 1));
    return list;

    //1->2->3->4->5
}

//Question 2.4 - 
function partition(list, value) {
    if(!list.get(value)) {
        return undefined;
    }

    const result = new SingleLinkedList();

    let node = list.head;
    while(node) {
        if(node.value < value) {
            console.log(node.value + " unshifted: " + node.value)
            result.unshift(node.value);
        } else {
            console.log(node.value + " pushed: " + node.value)
            result.push(node.value);
        }

        node = node.next
    }

    return result;
} 

function sum(listA, listB) {
    const longerList = listA.length > listB.length ? listA : listB;
    const shorterList = listA.legnth > listB.length ? listB : listA;
    const resultList  = new SingleLinkedList();

    let remainder = 0;
    for(let i = 0; i < longerList.length; i++) {
        const longerListNode = longerList.get(i);
        const shorterListNode = shorterList.get(i);
        let sum = 0;

        if(!shorterListNode) {
            sum = longerListNode.value;
        } else {
            sum = longerListNode.value + shorterListNode.value;
        }

        if(remainder) {
            sum += remainder;
            remainder = 0;
        }
        if(sum >= 10) {
            remainder = Math.floor(sum / 10);
            resultList.push(sum % 10);
        }
        if(sum < 10) {
            resultList.push(sum);
        }
        if(i === longerList.length - 1) {
            resultList.push(remainder);
        }
    }

    return resultList;
}

const listA = new SingleLinkedList();
const listB = new SingleLinkedList();
listA.push(7)
listA.push(1)
listA.push(6)
listB.push(7)
listB.push(1)
listB.push(6)

console.log(sum(listA, listB))