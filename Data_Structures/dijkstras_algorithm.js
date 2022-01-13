class WeightedGraph {
    constructor() {
        this.adjacencyList = {};
    }

    addVertex(value) {
        if(!this.adjacencyList[value]) {
            this.adjacencyList[value] = [];
        }
    }

    addEdge(vertex1, vertex2, weight) { //Undirected Graphs
        const list = this.adjacencyList
        if(list[vertex1] && list[vertex2] && !list[vertex1].includes(vertex2)) {
            this.adjacencyList[vertex1].push({node: vertex2, weight});
            this.adjacencyList[vertex2].push({node: vertex1, weight});
        }
    }

    removeElement(array, index) {
        let newArray;
        if(index === 0) {
            newArray = array.slice(1);
        } else if(index === array.length - 1) {
            newArray = array.slice(0, array.length - 1);
        } else {
            newArray = [...array.slice(0,index), ...array.slice(index + 1)];
        }
        return newArray;
    }

    removeEdge(vertex1, vertex2) {
        const list =  this.adjacencyList;
        const element = list[vertex1].filter(vertex => vertex.node === vertex2)
        if(list[vertex1] && list[vertex2] && list[vertex1].includes(element[0])) {
            list[vertex1] = list[vertex1].filter(vertex => vertex.node !== vertex2); //Use filter instead of removeElement, lol. Know your array methods!!
            list[vertex2] = list[vertex2].filter(vertex => vertex.node !== vertex1);
        }
    }

    removeVertex(vertex) {
        const list = this.adjacencyList;
        if(list[vertex]) {
            for(let edge of this.adjacencyList[vertex]) {
                this.removeEdge(vertex, edge.node);
            }
            delete list[vertex];
        }
    }

    dijkstras(start, end) {
        const nodes = new PriorityQueue(); //Creates priority queue that we dequeue from for each iteration of the loop.
        const distances = {}; //Stores the distances from the starting node.
        const previous = {}; // Stores the previous node in the traversal to the given node.
        const path = []; //Stores the traversal path to be returned at the end.
        let smallest; //Stores the node with the shortest distance to the starting node.

        for(let vertex in this.adjacencyList) {
            if(vertex === start) { //Ensures the starting node has a distance of zero and a priority of zero (highest).
                distances[vertex] = 0;
                nodes.insert(vertex, 0);
            } else { //Ensures all other nodes have a distance of infinity (unknown) and a priorty of infinity (lowest).
                distances[vertex] = Infinity;
                nodes.insert(vertex, Infinity);
            }
            previous[vertex] = null; //At the start, the graph hasn't been traversed, so there is no previous node in the traversal to a given node.
        }

        while(nodes.values.length) { //While there are nodes in the queue...
            smallest = nodes.remove().value; //Sets smallest to the node with the smallest distance from the starting node in the queue.
            if(smallest === end) { //When the smallest node in the queue is the ending node, the travseral is complete.
                while(previous[smallest]) { //Builds path array to be returned when the traversal is complete.
                    path.push(smallest);
                    smallest = previous[smallest];
                }
                break;
            }
            if(smallest || distances[smallest] !== Infinity) { //As long as the vertex dequeued is valid...
                for(let neighbor in this.adjacencyList[smallest]) { //For each node in the adjacency list of 'smallest'.
                    let nextNode = this.adjacencyList[smallest][neighbor]; //The node in the adjacency list (can be improved with for... of).
                    let candidate = distances[smallest] + nextNode.weight; //Potentially smaller distance from starting node.
                    if(candidate < distances[nextNode.node]) { //If the candidate is smaller than the distance currently stored in 'distances'...
                        distances[nextNode.node] = candidate; //Update the distance for that node to be the smaller distance.
                        previous[nextNode.node] = smallest; //Update the previous for the node to be 'smallest'.
                        nodes.insert(nextNode.node, candidate); //Add the neighbor of 'smallest to the queue with the updated priority.
                    }
                }
            }
        }
        return path.concat(smallest).reverse();
    }
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
    
    swap(array,a,b) {
        [array[a], array[b]] = [array[b], array[a]];
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
                this.swap(this.values, parentIndex, childIndex);
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
            this.swap(this.values, 0, this.values.length - 1);
            const head = this.values.pop();
            if(this.values.length > 1) {
                let currentIndex = 0;
                let currentPriority = this.values[currentIndex].priority;
                let childIndex = lesserIndex(this.values, 2*currentIndex + 1, 2*currentIndex + 2);
                let childPriority = this.values[childIndex].priority;
    
                while(childPriority < currentPriority) {
                    this.swap(this.values, currentIndex, childIndex);
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

const graph1 = new WeightedGraph();
graph1.addVertex("A");
graph1.addVertex("B");
graph1.addVertex("C");
graph1.addEdge("A", "B", 9);
graph1.addEdge("A", "C", 5);
graph1.addEdge("B", "C", 7);

const graph2 = new WeightedGraph();
graph2.addVertex("A");
graph2.addVertex("B");
graph2.addVertex("C");
graph2.addVertex("D");
graph2.addVertex("E");
graph2.addVertex("F");
graph2.addEdge("A", "B", 4);
graph2.addEdge("A", "C", 2);
graph2.addEdge("B", "E", 3);
graph2.addEdge("C", "D", 2);
graph2.addEdge("C", "F", 4);
graph2.addEdge("D", "E", 3);
graph2.addEdge("D", "F", 1);
graph2.addEdge("E", "F", 1);
console.log(graph2.dijkstras("A", "E"));

// Practice:
const distances = {
    "A": 0,
    "B": 4,
    "C": 2,
    "D": 4,
    "E": 6,
    "F": 5
}

const visited = ["A","C","B","D","F"];

const previous = {
    "A": null,
    "B": "A",
    "C": "A",
    "D": "C",
    "E": "B",
    "F": "F"
}

console.log("Adjacency List: ", graph2.adjacencyList)