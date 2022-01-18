function bubbleSort(array) {
    let swapped;
    for(let i = array.length; i > 0; i--) {
        swapped = false;
        for(let j = 0; j < i - 1; j++) {
            if(array[j + 1] < array[j]) {
                [array[j], array[j + 1]] = [array[j + 1], array[j]];
                swapped = true;
            }
        }
        if(!swapped) {
            break;
        }
    }

    return array;
}

function bubbleSort2(array, comparator) {    
    let swapped;

    if(typeof comparator !== 'function') {
        comparator = function(a,b) {
            if(a > b) {
                return 1;
            } else if(a < b) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    for(let i = array.length; i > 0; i--) {
        swapped = false;
        for(let j = 0; j < i - 1; j++) {
            if(comparator(array[j], array[j + 1]) > 0) {
                swapped = true;
                [array[j], array[j + 1]] = [array[j +1], array[j]];
            }
        }
        if(!swapped) {
            break;
        }
    }

    return array;
}

const array = ["Lilbub", "Garfield", "Heathcliff", "Blue", "Grumpy"];
const comparator = function(a,b) {
    if(a > b) {
        return 1;
    } else if(a < b) {
        return -1;
    } else {
        return 0;
    }
}

function selectionSort(array) {
    for(let i = 0; i < array.length; i++) {
        let minIndex = i;
        for(let j = i + 1; j < array.length; j++) {
            if(array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        if(minIndex !== i) {
            [array[i], array[minIndex]] = [array[minIndex], array[i]];
        }
    }

    return array;
}

function selectionSort2(array, comparator) {
    if(typeof comparator !== 'function') {
        comparator = function(a, b) {
            if(a > b) {
                return 1;
            } else if(a < b) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    for(let i = 0; i < array.length; i++) {
        let minIndex = i;
        for(let j = i + 1; j < array.length; j++) {
            if(comparator(array[j], array[minIndex]) < 0) {
                minIndex = j;
            }
        }
        if(minIndex !== i) {
            [array[i], array[minIndex]] = [array[minIndex], array[i]];
        }
    }

    return array;
}

const array2 = [0, -10, 7, 4];

function insertionSort(array) {
    for(let i = 1; i < array.length; i++) {
        const element = array[i];
        for(let j = i - 1; j >= 0; j--) {
            if(element < array[j]) {
                [array[j], array[j+1]] = [array[j+1], array[j]];
            } else break
        }
    }
    return array
}

function insertionSort2(array, comparator) {
    if(typeof comparator !== 'function') {
        comparator = function(a,b) {
            if(a < b) {
                return 1;
            } else if(a > b) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    for(let i = 1; i < array.length; i++) {
        const element = array[i];
        for(let j = i - 1; j >= 0; j--) {
            if(comparator(element, array[j] > 0)) {
                [array[j], array[j+1]] = [array[j+1], array[j]];
            } else break
        }
    }
    return array
}

const array3 = [9, 10, 12, 20, 4, 4, 7];
console.log(insertionSort(array3));