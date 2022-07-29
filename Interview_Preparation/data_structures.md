# Data Structures

## Arrays and Strings
- Array questions and String questions are often interchangeable. A question that requires a String-based solution could be changed to require an Array-based solution.
- `Arrays` can be used to implement a Hash Table in the following manner: The Hash Table is structured as an array of linked list.
    - Each node of each linked list stores a key-value pair.
    - A pair is added to a hash table by hashing the key and converting the hash value into an index (typically using modulus).
    - This way, a key is mapped to an index by its hash value.
    - The key-value pair is stored in one of the nodes of a linked list.
    - If there is a collision, where two keys produce the same hash value or different hash values convert to the same index, the key-value pair is stored in the next available node of the linked list at that index
    - To look up a pair by its key, you use the key's hash code to find its index, then search the linked list for that key.
    - Assuming a good hashing algorithm, each linked list will only have one pair, resulting in O(1) look up.
    - In the worst-case scenario, where all pairs are stored in one linked list, look up would be O(N).
- An `ArrayList` is an important data structure for interviews because it offers the benefits of an array (O(1) index-based access) with the added benefit of dynamic sizing.
    - The dynamic resizing of an array has a time complexity of O(N), but this is amortized (spread out over time), meaning the overall time complexity for access in an ArrayList is still O(1).
    - Justification: Consider an array with a final size n (number of elements). It took n/2 operations for the final capacity increase (assuming a resizing factor of 2). The previous resizing took n/4 operations (half n/2). The one before that took n/8, and so on. The limit of this sum as denominator approaches infinity is 1.
- A `StringBuilder` is like an ArrayList in that it solves the sizing problem that regular Strings have.
    - Strings are immutable. This means that, if you want to concatenate two strings, you need to create a new String and copy all of the characters into the new string. For two Strings of size x, this would take 2x operations. If you had a function that took an array of uniformly sized strings of size x and combined them into one string, the time complexity would be O(x*N2).
    - Reasoning: Copying the first two Strings takes 2x operations, adding on the third string takes 3x operations, the fourth takes 4x operations. The sum of these operations is on the order of N^2, multiplied by the length of each string (x) gives O(x*N2).
    - StringBuilder solves this problem by creating String that can be dynamically resized, so appending a String doesn't require the creation of a whole new string.
