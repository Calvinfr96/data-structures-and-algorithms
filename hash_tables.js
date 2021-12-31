class HashTable {
    constructor(size=53) {
        this.keyMap = new Array(size);
    }

    _hash(key) {
        let total = 0;
        let WEIRD_PRIME = 31;
        for(let i = 0; i < Math.min(key.length,100); i++) {
            let char = key[i];
            let value = char.charCodeAt(0) - 96;
            total = (total*WEIRD_PRIME + value) % this.keyMap.length;
        }
        return total;
    }

    set(key, value) {
        const keyValue = [key, value];
        const hashedKey = this._hash(key);

        if(!Array.isArray(this.keyMap[hashedKey])) {
             this.keyMap[hashedKey] = [keyValue];
        } else {
            this.keyMap[hashedKey].push(keyValue);
        }
    }

    get(key) {
        const hashedKey = this._hash(key);
        for(let keyValue of this.keyMap[hashedKey]) {
            if(keyValue[0] === key) {
                return keyValue[1];
            }
        }
    }
}

const hash = new HashTable(5);
hash.set('pink', 43);
hash.set('pnik', 34);
hash.set('orange', 52);
hash.set('blue', 86);
hash.set('purple', 112);
console.log(hash.get('blue'))