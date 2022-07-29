class MaxBinaryHeap {
    constructor() {
        this.values = [];
    }

    swap(array, a, b) {
        [array[a], array[b]] = [array[b], array[a]];
    }

    insert(value) {
        this.values.push(value);
        let childIndex = this.values.length - 1;
        let parentIndex = Math.floor((childIndex - 1) / 2);
        let childValue = this.values[childIndex];
        let parentValue = this.values[parentIndex];

        while(childValue > parentValue) {
            this.swap(this.values, childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = Math.floor((childIndex - 1) / 2);
            childValue = this.values[childIndex];
            parentValue = this.values[parentIndex];
        }
    }

    greaterChild(parentIndex) {
        const childIndex1 = 2*parentIndex + 1;
        const childIndex2 = 2*parentIndex + 2;
        const childValue1 = this.values[childIndex1];
        const childValue2 = this.values[childIndex2];

        if(childValue1 && childValue1 > childValue2) {
            return childIndex1;
        } else if(childValue2 && childValue2 > childValue1) {
            return childIndex2;
        } else {
            return undefined;
        }
    }

    extractMax() {
        if(!this.values.length) {
            return undefined;
        }

        this.swap(this.values, 0, this.values.length - 1);
        const max = this.values.pop();
        let parentIndex = 0;
        let childIndex = this.greaterChild(parentIndex);

        while(childIndex) {
            this.swap(this.values, parentIndex, childIndex);
            parentIndex = childIndex;
            childIndex = this.greaterChild(parentIndex)
        }

        return max;
    }
}

const heap = new MaxBinaryHeap();
heap.insert(10)
heap.insert(9)
heap.insert(8)
heap.insert(7)
heap.insert(6)
heap.insert(5)
heap.insert(4)
heap.insert(20)