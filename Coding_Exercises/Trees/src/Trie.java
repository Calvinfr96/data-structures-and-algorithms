import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
* A trie, also known as a prefix tree, is a tree that is used to store words.
* A trie can be structured such that each node contains a single character or a null value
* to indicate a complete word. Alternatively, each node (character) can contain a boolean value
* that determines if it forms a complete word.
*/
public class Trie {
    Map<Character, Node> root;

    public Trie() {
        root = new HashMap<>();
    }


    public static class Node {
        public Map<Character, Node> children;
        public boolean terminal;

        public Node() {
            children = new HashMap<>();
            terminal = false;
        }
    }

    public boolean insert(String word) {
        char[] characters = word.toCharArray();
        root.putIfAbsent(characters[0], new Node());
        Node current = root.get(characters[0]);
        for(int i = 1; i < characters.length; i++) {
            current.children.putIfAbsent(characters[i], new Node());
            current = current.children.get(characters[i]);
        }

        if(current.terminal) {
            return false;
        } else {
            current.terminal = true;
            return true;
        }
    }

    public boolean remove(String word) {
        Node endingNode = endingNode(word);
        
        if(!Objects.isNull(endingNode) && endingNode.terminal) {
            endingNode.terminal = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean isWord(String word) {
        Node endingNode = endingNode(word);

        if(!Objects.isNull(endingNode)) {
            return endingNode.terminal;
        } else {
            return false;
        }
    }

    public boolean isPrefix(String prefix) {
        Node endingNode = endingNode(prefix);

        if(!Objects.isNull(endingNode)) {
            return !endingNode.children.isEmpty();
        } else {
            return false;
        }
    }

    public Node endingNode(String word) {
        char[] characters = word.toCharArray();
        Node current = root.get(characters[0]);
        for(int i = 1; i < characters.length; i++) {
            if(!Objects.isNull(current)) {
                current = current.children.get(characters[i]);
            } else {
                return null;
            } 
        }

        return current;
    }
}
