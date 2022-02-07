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
}

const heap = new MaxBinaryHeap();
heap.insert(1)
heap.insert(2)
heap.insert(3)
heap.insert(4)
heap.insert(5)
heap.insert(6)