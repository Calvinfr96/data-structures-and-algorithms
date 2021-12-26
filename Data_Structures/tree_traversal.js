//Using BST class to demonstrate various traversal algorithms
class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    constructor() {
        this.root = null;
    }

    insert(value) {
        const node = new Node(value);

        if(!this.root) {
            this.root = node;
        } else {
            let currentNode = this.root;
            while(true) {
                if(value === currentNode.value) {
                    return undefined;
                }
                if(value < currentNode.value) {
                    if(!currentNode.left) {
                        currentNode.left = node;
                        return this;
                    } else {
                        currentNode = currentNode.left;
                    }
                }
                if(value > currentNode.value) {
                    if(!currentNode.right) {
                        currentNode.right = node;
                        return this;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
        
        return this;
    }

    find(value) {
        if(!this.root) {
            return undefined;
        }

        let currentNode = this.root;
        if(value === currentNode.value) {
            return currentNode;
        } else {
            while(currentNode) {
                if(value > currentNode.value) {
                    currentNode = currentNode.right;
                } else if(value < currentNode.value) {
                    currentNode = currentNode.left;
                } else {
                    return currentNode;
                }
            }
            return undefined;
        }
    }
}

//Breadth-First Search
const tree = new BinarySearchTree();
tree.insert(10);
tree.insert(6);
tree.insert(15);
tree.insert(3);
tree.insert(8);
tree.insert(20);

function breadthFirstSearch(tree) {
    const queue = [];
    const visited = [];
    queue.push(tree.root)

    function traverse(queue) {
        const node = queue.shift();
        if(node.left) {
            queue.push(node.left);
        }
        if(node.right) {
            queue.push(node.right);
        }
        visited.push(node.value);
        if(queue.length !== 0) {
            traverse(queue);
        }
    }

    traverse(queue);
    return visited;
}

const traversal = breadthFirstSearch(tree);
console.log(traversal)