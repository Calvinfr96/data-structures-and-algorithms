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

    remove(value) {
        /* Things to Consider:
            1. The removal of a node depends on its position within the tree and how many children it has.
            2. There are three types of nodes: leaves, nodes with one child, and nodes with two children.
            3. Case 1: Deleting a leaf node is relatively straightforward. You go to the parent of the leaf, then set the pointer that
            references the leaf to null.
            4. Case 2: To delete a node with one child, you replace that node with its only child. In other words, you go the parent of
            the node and update the reference to that node so that it points to its only child.
            5. Case 3: To delete a node with two children, you must replace that node with its in-order successor. The in-order successor
            of a node can be the smallest value in the right subtree or the largest value in the left subtree.For a BST, this is the 
            left-most node in the right subtree or the right-most node in the left subtree. To perform the replacement, follow this procedure:
                1. Copy the value of the node found in the subtree to the node you want to remove.
                2. Recursively remove the node copied in the previous step.
        */

        const node = this.find(value);
        const parent = this.findParent(value);

        if(!this.root.left && !this.root.right) {
            this.root = null;
        }

        if(!node) {
            return undefined;
        } else if(node.left && node.right) {
            let successor = node.right;
            let subtree = node.right;
            while(subtree.left) {
                successor = subtree.left;
                subtree = subtree.left;
            }

            this.remove(successor.value)
            node.value = successor.value;

        } else if(node.left || node.right) {
            if(value < parent.value) {
                node.left ? parent.left = node.left : parent.left = node.right;
            }
            if(value > parent.value) {
                node.left ? parent.right = node.left : parent.right = node.right;
            }
        } else {
            if(value < parent.value) {
                parent.left = null;
            }
            if(value > parent.value) {
                parent.right = null;
            }
        }

        return this;
    }

    findParent(value) {
        if(!this.root) {
            return undefined;
        } else {
            let previous = null;
            let current = this.root;
            while(current) {
                if(value < current.value) {
                    previous = current;
                    current = current.left;
                } else if(value > current.value) {
                    previous = current;
                    current = current.right;
                } else {
                    return previous;
                }
            }

            return undefined;
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

    getLevel(value) {
        if(!this.root) {
            return undefined;
        } else {
            let current = this.root;
            let level = 1;
            while(current) {
                if(value < current.value) {
                    current = current.left;
                    level++;
                } else if(value > current.value) {
                    current = current.right;
                    level++;
                } else {
                    return level;
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

    findSecondLargest() {
        if(!this.root) {
            return undefined;
        }

        let largest = this.root;
        while(largest.right) {
            largest = largest.right;
        }

        const parent = this.findParent(largest.value);
        if(largest.left) {
            return largest.left.value;
        } else if(parent) {
            return parent.value;
        } else {
            return undefined;
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

    isBalanced() {
        /*
        Deternmine if a BST is balanced by retruning true if balanced and false otherwise. A BST is balanced when the depth of all
        nodes with less than two children differ by no more than one.

        Figure out a way to record the height of each node with less than two children using a depth-first traversal.
        Store these heights in an array and determine if the values in the array differ by less than two.
        */
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
bst.insert(49)
console.log(bst.getLevel(15))