class Trie {
    constructor() {
        this.characters = {}; //The characters object maps each character of a word to a nested trie
        this.isWord = false; //This is an indication of whether the key forms a complete word.
    }

    addWord(word, index = 0) {//Example: 'mood', 0, 1, 2, 3, 4
        if (index === word.length) {// false, false, false, false, true
            this.isWord = true;//
        } else if (index < word.length) {// true, true, true, true
            var char = word[index];// 'm', 'o', 'o', 'd'
            var subTrie = this.characters[char] || new Trie();//new Trie(), new Trie(), new Trie(), new Trie()
            subTrie.addWord(word, index + 1);//addWord(1), addWord(2), addWord(3), addWord(4)
            this.characters[char] = subTrie;//
        }
        return this;//
    }
}