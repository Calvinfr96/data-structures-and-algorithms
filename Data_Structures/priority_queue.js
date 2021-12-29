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
    
    insert(value) {
        this.values.push(value)
        let childIndex = this.values.length - 1;
        let parentIndex = Math.floor((childIndex - 1) / 2);
        let childValue = this.values[childIndex];
        let parentValue = this.values[parentIndex];

        while(childIndex > 0 && childValue > parentValue) {
            swap(this.values, parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = Math.floor((childIndex - 1) / 2);
            childValue = this.values[childIndex];
            parentValue = this.values[parentIndex];
        }
    }

    remove() {
        function greaterIndex(array, a, b) {
            const length = array.length
            if(a < length && b < length) {
                const maxValue = Math.max(array[a], array[b]);
                let maxIndex;
                array[a] === maxValue ? maxIndex = a : maxIndex = b;
                return maxIndex;
            } else {
                return a < length ? a : b
            }
        }

        if(!this.values.length) {
            return undefined;
        } else if(this.values.length === 1) {
            return this.values.pop();
        } else {
            swap(this.values, 0, this.values.length - 1);
            const head = this.values.pop();
            let currentIndex = 0;
            let currentValue = this.values[currentIndex];
            let childIndex = greaterIndex(this.values, 2*currentIndex + 1, 2*currentIndex + 2);
            let childValue = this.values[childIndex];

            while(childValue > currentValue) {
                swap(this.values, currentIndex, childIndex);
                currentIndex = childIndex;
                childIndex = greaterIndex(this.values, 2*currentIndex + 1,2*currentIndex + 2);
                currentValue = this.values[currentIndex];
                childValue = this.values[childIndex];
            }

            return head;
        }
    }
}

const queue = new PriorityQueue();