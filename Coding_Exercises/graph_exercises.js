class Graph {
    constructor() {
        this.adjacencyList = {};
    }

    addVertex(vertex) {
        if(!this.adjacencyList[vertex]) {
            this.adjacencyList[vertex] = [];
        }

        return this;
    }

    addEdge(vertex1, vertex2) {
        if(this.adjacencyList[vertex1] && this.adjacencyList[vertex2]) {
            const edge1 = this.adjacencyList[vertex1].find(vertex => vertex === vertex2);
            if(!edge1) {
                this.adjacencyList[vertex1].push(vertex2);
                this.adjacencyList[vertex2].push(vertex1);
            }
        }
    }

    removeEdge(vertex1, vertex2) {
        if(this.adjacencyList[vertex1] && this.adjacencyList[vertex2]) {
            const edge1 = this.adjacencyList[vertex1].find(vertex => vertex === vertex2);
            if(edge1) {
                this.adjacencyList[vertex1] = this.adjacencyList[vertex1].filter(vertex => vertex !== vertex2);
                this.adjacencyList[vertex2] = this.adjacencyList[vertex2].filter(vertex => vertex !== vertex1);
            }1
        }
    }
}

const graph = new Graph();

graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addEdge("A", "B")
graph.addEdge("B", "A")
graph.addEdge("C", "A")
graph.removeEdge("A", "C")

console.log(graph);