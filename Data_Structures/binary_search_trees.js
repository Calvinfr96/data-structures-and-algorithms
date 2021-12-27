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

    breadthFirstSearch() {
        const queue = [];
        const visited = [];
        queue.push(this.root)
    
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

    preOrderSearch() {
        const visited = [];
    
        function traverse(node) {
            visited.push(node.value)
            if(node.left) {
                traverse(node.left);
            }
            if(node.right) {
                traverse(node.right);
            }
        }
    
        traverse(this.root);
        return visited;
    }
}

const tree = new BinarySearchTree();