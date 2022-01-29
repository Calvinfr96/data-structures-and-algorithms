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
            return this;
        } else {
            let current = this.root;

            while(true) {
                if(node.value < current.value) {
                    if(!current.left) {
                        current.left = node;
                        return this;
                    } else {
                        current = current.left;
                    }
                } else if(node.value > current.value) {
                    if(!current.right) {
                        current.right = node;
                        return this;
                    } else {
                        current = current.right;
                    }
                } else {
                    return undefined;
                }
            }
        }
    }

    find(value) {
        if(!this.root) {
            return undefined;
        } else {
            let current = this.root;
            while(current) {
                if(value < current.value) {
                    current = current.left;
                } else if(value > current.value) {
                    current = current.right;
                } else {
                    return current;
                }
            }

            return undefined;
        }
    }

    findRecursive(value, node = this.root) {
        if(!node) {
            return undefined;
        } else if(value < node.value) {
            return this.findRecursive(value, node.left);
        } else if(value > node.value) {
            return this.findRecursive(value, node.right);
        } else {
            return node;
        }
    }

    breadthFirstSearch() {
        const queue = [];
        const visited = [];
        queue.push(this.root);

        while(queue.length) {
            const node = queue.shift();
            visited.push(node.value);
            if(node.left) {
                queue.push(node.left);
            }
            if(node.right) {
                queue.push(node.right);
            }
        }

        return visited;
    }

    DFSPreOrder() {
        const visited = [];

        function traverse(node) {
            visited.push(node.value);
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

    DFSPostOrder() {
        const visited = [];

        function traverse(node) {
            if(node.left) {
                traverse(node.left);
            }
            if(node.right) {
                traverse(node.right);
            }
            visited.push(node.value);
        }

        traverse(this.root);
        return visited;
    }

    DFSInOrder() {
        const visited = [];

        function traverse(node) {
            if(node.left) {
                traverse(node.left);
            }
            visited.push(node.value);
            if(node.right) {
                traverse(node.right);
            }
        }

        traverse(this.root);
        return visited;
    }
}

const bst = new BinarySearchTree();
bst.insert(15)
bst.insert(20)
bst.insert(10)
bst.insert(12)
bst.insert(1)
bst.insert(5)
bst.insert(50)