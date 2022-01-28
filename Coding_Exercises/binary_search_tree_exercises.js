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
}

const bst = new BinarySearchTree();
bst.insert(10)
bst.insert(5)
bst.insert(15)
bst.insert(6)
bst.insert(4)
bst.insert(14)
bst.insert(16)