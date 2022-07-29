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

    removeVertex(vertex) {
        const edges = this.adjacencyList[vertex];
        for(let edge of edges) {
            this.removeEdge(vertex, edge);
        }
        delete this.adjacencyList[vertex];
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

    DFTRecusrive(start) {
        const results = [];
        const visited = {};
        const list = this.adjacencyList;

        function traverse(vertex) {
            if(!list[vertex].length) {
                return;
            }

            results.push(vertex);
            visited[vertex] = true;

            for(let node of list[vertex]) {
                if(!visited[node]) {
                    traverse(node);
                }
            }
        }

        traverse(start);
        return results;
    }

    BFTraversal(start) {
        const queue = [];
        const visited = {};
        const results = [];
        const list = this.adjacencyList;
        let current;

        queue.push(start);
        visited[start] = true;
        while(queue.length) {
            current = queue.shift();
            results.push(current);

            for(let neighbor of list[current]) {
                if(!visited[neighbor]) {
                    queue.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return results;
    }
}

const graph = new Graph();

graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addEdge("A", "B")
graph.addEdge("B", "A")
graph.addEdge("C", "A")
console.log(graph.DFTRecusrive("A"))