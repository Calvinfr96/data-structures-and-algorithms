class MaxBinaryHeap {
    constructor() {
        this.values = [];
    }
    
    insert(value) {
        this.values.push(value)
        let childIndex = this.values.length - 1;
        let parentIndex = Math.floor((childIndex - 1) / 2);
        let childValue = this.values[childIndex];
        let parentValue = this.values[parentIndex];

        function swap(array,a,b) {
            [array[a], array[b]] = [array[b], array[a]];
        }

        while(childIndex > 0 && childValue > parentValue) {
            swap(this.values, parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = Math.floor((childIndex - 1) / 2);
            childValue = this.values[childIndex];
            parentValue = this.values[parentIndex];
        }
    }
}

const heap = new MaxBinaryHeap();
heap.values = [];
console.log(heap)
heap.insert(34)
console.log(heap)