//Using the Graph class to demonstrate depth and breadth-first search algorithms
class Graph {
    constructor() {
        this.adjacencyList = {};
    }

    addVertex(value) {
        if(!this.adjacencyList[value]) {
            this.adjacencyList[value] = [];
        }
    }

    addEdge(vertex1, vertex2) { //Undirected Graphs
        const list = this.adjacencyList
        if(list[vertex1] && list[vertex2] && !list[vertex1].includes(vertex2)) {
            this.adjacencyList[vertex1].push(vertex2);
            this.adjacencyList[vertex2].push(vertex1);
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
        if(list[vertex1] && list[vertex2] && list[vertex1].includes(vertex2)) {
            const index1 = this.adjacencyList[vertex2].indexOf(vertex1);
            const index2 = this.adjacencyList[vertex1].indexOf(vertex2);
            list[vertex1] = this.removeElement(list[vertex1], index2); //Or just use filter, lol. Know your array methods!!
            list[vertex2] = list[vertex2].filter(vertex => vertex !== vertex1)
        }
    }

    removeVertex(vertex) {
        const list = this.adjacencyList;
        if(list[vertex]) {
            for(let edge of this.adjacencyList[vertex]) {
                this.removeEdge(vertex, edge);
            }
            delete list[vertex];
        }
    }

    DFSRecursive(vertex) {
        const results = [];
        const visited = {};
        const list = this.adjacencyList;

        function traverse(vertex) {
            if(!vertex) { //Can potentially cause issues if you have a graph with numerical vertices and want to start at 0
                return null;
            } else { //There's sort of an implicit base case with this recursion. Each for loop is blocked by a recursive call until one loop
                     //is able to finish, then the other loops behind it can continue and finish. The explicit base case above doesn't really work.
                results.push(vertex);
                visited[vertex] = true;
                list[vertex].forEach(neighbor => {
                    if(!visited[neighbor]) {
                        return traverse(neighbor);
                    }
                })
            }
        }

        traverse(vertex)
        return results;
    }
    
    DFSIterative(vertex) {
        const stack = [];
        const results = [];
        const visited = {};
        const list = this.adjacencyList;

        stack.push(vertex);
        visited[vertex] = true;

        while(stack.length) {
            const current = stack.pop();
            results.push(current);
            for(let neighbor of list[current]) {
                if(!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return results;
    }

    BFS(vertex) {
        const queue = [];
        const results = [];
        const visited = {};
        const list = this.adjacencyList;
        let current

        queue.push(vertex);
        visited[vertex] = true;

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

const exampleGraph = new Graph();
exampleGraph.addVertex("A");
exampleGraph.addVertex("B");
exampleGraph.addVertex("C");
exampleGraph.addVertex("D");
exampleGraph.addVertex("E");
exampleGraph.addVertex("F");

exampleGraph.addEdge("A","B");
exampleGraph.addEdge("A","C");
exampleGraph.addEdge("B","D");
exampleGraph.addEdge("C","E");
exampleGraph.addEdge("D","E");
exampleGraph.addEdge("D","F");
exampleGraph.addEdge("E","F");

console.log(exampleGraph.adjacencyList)
console.log(exampleGraph.BFS("A"))