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
}

const graph = new WeightedGraph();
graph.addVertex("A")
graph.addVertex("B")
graph.addVertex("C")
graph.addEdge("A", "B", 9)
graph.addEdge("A", "C", 5)
graph.addEdge("B", "C", 7)
console.log(graph.adjacencyList)
graph.removeVertex("A")
console.log(graph.adjacencyList)