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

//Question 2.5
function sortLists(list1, list2) {
    const shorter = list1.length > list2.length ? list2 : list1;
    const longer = list1.length > list2.length ? list1 : list2;

    return [shorter, longer];
}

function sum(listA, listB) {
    const shorterList = sortLists(listA, listB)[0];
    const longerList = sortLists(listA, listB)[1];
    console.log(longerList)
    console.log(shorterList)
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

//Question 2.6 - 
function palindrome(list) {
    let pointer1 = 0;
    let pointer2 = list.length - 1;

    while(pointer1 < pointer2) {
        if(list.get(pointer1).value !== list.get(pointer2).value) {
            return false;
        }

        pointer1++;
        pointer2--;
    }

    return true;
}

//Question 2.7 - 
function intersection(listA, listB) {
    const nodeTableA = {};
    const nodeTableB = {};
    
    for(let i = 0; i < listA.length; i++) {
        nodeTableA[listA.get(i).value] || (nodeTableA[listA.get(i).value] = listA.get(i))
    }

    for(let j = 0; j < listB.length; j++) {
        console.log("looping...")
        nodeTableB[listB.get(j).value] || (nodeTableB[listB.get(j).value] = listB.get(j))
    }
    
    for(let key in nodeTableA) {
        if(nodeTableA[key] === nodeTableB[key]) {
            return true;
        }
    }

    return false;
}

//Question 2.9
function basicLoopDetection(list) {
    if(list.head = null) { //prevents null pointer exception when assigning fast and slow pointers
        return false;
    }

    let slowPointer = list.head;
    let fastPointer = list.head.next;

    while(fastPointer !== null && slowPointer !== null && fastPointer.next !== null) {
        //If the list contains a loop, this could be an infinite loop. If not, the loop will terminate when the 
        //fast pointer reaches the end of the list.
        if(fastPointer === slowPointer) {
            return [slowPointer, fastPointer];//breaks out of the loop when the pointers meet, preventing an infinite loop.
        }

        //advances each pointer according to the "runner" technique.
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next.next;
    }

    //if we break out of the loop without returning true, the list does not contain a loop.
    return null;
}

function loopDetection(list) {
    //If the list has a non-looped portion (K) and looped portion and the pointers move at 2:1 ratio, by the time the slow runner enters the looped portion of the list, the fast runner will be k steps into the loop (When K >> Loop_Size, it's K % Loop_Size. Each subsequent step will move the runners one step closer to one another.
    //When the slow runner first enters the loop, the fast runner is Loop_Size - K steps behind it (K steps ahead). This means it will take Loop_Size - K steps for the two to meet each other. At this collision point, they will be K steps behind the head of the loop. The head of the loop is also K steps from the head of the loop.
    //If we move one pointer back to the head and keep the other one at the collision point, then move both pointers at the same speed, they will meet again at the head of the loop and you can simply return this node.

    if(!basicLoopDetection(list)) {
        return null;
    }

    let [slowPointer, fastPointer] = basicLoopDetection(list);

    slowPointer = this.head;

    while(slowPointer !== fastPointer) {
        slowPointer = slowPointer.next;
        fastPointer = fastPointer.next;
    }

    return fastPointer;
}

const node1A = new Node(1);
const node2A = new Node(2);
const node3A = new Node(3)

const node1B = new Node(1);
const node2B = node2A;
const node3B = new Node(3);

const listA = new SingleLinkedList();
const listB = new SingleLinkedList();

listA.head = node1A
listA.head.next = node2A
listA.head.next.next = node3A
listA.tail = node3A
listA.length = 3;

listB.head = node1B
listB.head.next = node2B
listB.head.next.next = node3B
listB.tail = node3B
listB.length = 3;

console.log(intersection(listA, listB))