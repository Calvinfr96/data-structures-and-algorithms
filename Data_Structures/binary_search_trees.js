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
}

const tree = new BinarySearchTree();