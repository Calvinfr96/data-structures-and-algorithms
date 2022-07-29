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

    findWord(word, index = 0) {
        // This function will return the node in the trie
        // which corresponds to the end of the passed in word.

        // Be sure to consider what happens if the word is not in this Trie.

        var char = word[index];
        if (index < word.length - 1 && this.characters[char]) {
            index += 1;
            return this.characters[char].findWord(word, index);
        } else {
            return this.characters[char];
        }
    }
    getWords(words = [], currentWord = "") {
        // This function will return all the words which are
        // contained in this Trie.
        // it will use currentWord as a prefix,
        // since a Trie doesn't know about its parents.

        if (this.isWord) {
            words.push(currentWord);
        }
        for (var char in this.characters) {
            var nextWord = currentWord + char;
            this.characters[char].getWords(words, nextWord);
        }
        return words;
    }
    autoComplete(prefix) {
        // This function will return all completions
        // for a given prefix.
        // It should use find and getWords.
        var subTrie = this.find(prefix);
        if (subTrie) {
            return subTrie.getWords([], prefix);
        } else {
            return [];
        }
    }
}