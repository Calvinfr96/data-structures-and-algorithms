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
}