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
        const nodes = new basicPrioirtyQueue();
        const distances = {};
        const previous = {};
        const path = [];
        let smallest;

        for(let vertex in this.adjacencyList) {
            if(vertex === start) {
                distances[vertex] = 0;
                nodes.enqueue(vertex, 0);
            } else {
                distances[vertex] = Infinity;
                nodes.enqueue(vertex, Infinity);
            }
            previous[vertex] = null;
        }

        while(nodes.values.length) {
            smallest = nodes.dequeue().value;
            if(smallest === end) {
                while(previous[smallest]) {
                    path.push(smallest);
                    smallest = previous[smallest];
                }
                break;
            }
            if(smallest || distances[smallest] !== Infinity) {
                for(let neighbor in this.adjacencyList[smallest]) {
                    let nextNode = this.adjacencyList[smallest][neighbor];
                    let candidate = distances[smallest] + nextNode.weight;
                    if(candidate < distances[nextNode.node]) {
                        distances[nextNode.node] = candidate;
                        previous[nextNode.node] = smallest;
                        nodes.enqueue(nextNode.node, candidate);
                    }
                }
            }
        }
        return path.concat(smallest).reverse();
    }
}

class basicPrioirtyQueue {
    constructor() {
        this.values = [];
    }

    sort() {
        this.values.sort((a,b) => a.priority - b.priority)
    }

    enqueue(value, priority) {
        this.values.push({value, priority});
        this.sort()
    }

    dequeue() {
        return this.values.shift();
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
console.log(graph2.dijkstras("A", "A"));