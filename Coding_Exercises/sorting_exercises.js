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