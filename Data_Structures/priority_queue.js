function swap(array,a,b) {
    [array[a], array[b]] = [array[b], array[a]];
}

class Node {
    constructor(value, priority) {
        this.value = value;
        this.priority = priority;
    }
}

class PriorityQueue {
    constructor() {
        this.values = [];
    }
    
    insert(value, priority) {
        const node = new Node(value, priority);
        this.values.push(node);

        if(this.values.length > 1) {
            let childIndex = this.values.length - 1; //2
            let parentIndex = Math.floor((childIndex - 1) / 2); //0
            let childPriority = this.values[childIndex].priority;
            let parentPriority = this.values[parentIndex].priority;
    
            while(childPriority < parentPriority) {
                swap(this.values, parentIndex, childIndex);
                childIndex = parentIndex;
                parentIndex = Math.floor((childIndex - 1) / 2);
                if(parentIndex < 0) {
                    break;
                }
                childPriority = this.values[childIndex].priority;
                parentPriority = this.values[parentIndex].priority;
            }
        }
    }

    remove() {
        function lesserIndex(array, a, b) {
            const length = array.length
            if(a < length && b < length) {
                const minValue = Math.min(array[a].priority, array[b].priority);
                let minIndex;
                array[a].priority === minValue ? minIndex = a : minIndex = b;
                return minIndex;
            } else {
                return a < length ? a : b
            }
        }

        if(!this.values.length) {
            return undefined;
        } else if(this.values.length <= 1) {
            return this.values.pop();
        } else {
            swap(this.values, 0, this.values.length - 1);
            const head = this.values.pop();
            if(this.values.length > 1) {
                let currentIndex = 0;
                let currentPriority = this.values[currentIndex].priority;
                let childIndex = lesserIndex(this.values, 2*currentIndex + 1, 2*currentIndex + 2);
                let childPriority = this.values[childIndex].priority;
    
                while(childPriority < currentPriority) {
                    swap(this.values, currentIndex, childIndex);
                    currentIndex = childIndex;
                    childIndex = lesserIndex(this.values, 2*currentIndex + 1,2*currentIndex + 2);
                    if(childIndex >= this.values.length) {
                        break;
                    }
                    currentPriority = this.values[currentIndex].priority;
                    childPriority = this.values[childIndex].priority;
                }
            }

            return head;
        }
    }
}

const queue = new PriorityQueue();