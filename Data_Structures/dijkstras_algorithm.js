class Vertex {
    constructor(name, value) {
        this.name = name;
        this.value = value;
    }
}

class WeightedGraph {
    constructor() {
        this.adjacencyList = {};
    }

    addVertex(value) {
        const vertex = new Vertex(value);

        if(!this.adjacencyList[vertex.name]) {
            this.adjacencyList[vertex.name] = [];
        }
    }

    addEdge(vertex1, vertex2, weight) { //Undirected Graphs
        const list = this.adjacencyList
        if(list[vertex1.name] && list[vertex2.name] && !list[vertex1.name].includes(vertex2.name)) {
            vertex2.value = weight;
            this.adjacencyList[vertex1.name].push(vertex2);
            vertex1.value = weight;
            this.adjacencyList[vertex2.name].push(vertex1);
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
}