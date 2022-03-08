class Trie {
    constructor() {
        this.characters = {}; //The characters object maps each character of a word to a nested trie
        this.isWord = false; //This is an indication of whether the key forms a complete word.
    }

    //Each character at the 'root' of the Trie represents all words that start with that letter.
    //In the example below, we're adding 'mood' to the trie. So m is added to the 'root'.
    //The isWord tells you if that character completes a word. No character at the 'root' should have isWord set to true.
    //When the base case (the last letter of the word) is reached, the subTrie for that letter (with isWord set to true) is
    //added as a value to the key that corresponds to the letter before it.
    //So when 'd'is reached, isWord is set to true and that trie is set to the key 'o'.


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

    removeWord(word, index = 0) {

    }
}