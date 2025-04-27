MyHashTable and BST Implementation
This project implements:

A custom Hash Table (MyHashTable) with chaining (Linked List) for collision handling.

A Binary Search Tree (BST) without using recursion.

Both implementations avoid using Java’s built-in libraries for hash tables or trees, following all requirements.

MyHashTable Features
Supports generic key-value pairs (K, V).

Collision resolution through chaining (linked lists).

Custom HashNode internal class.

Basic operations:

put(K key, V value)

get(K key)

remove(K key)

contains(V value)

getKey(V value)

Custom hashing function (no Objects.hash() used).

Testing with 10,000 random elements and bucket load distribution.

Example Test Class
A MyTestingClass was created to:

Provide a custom hashCode() method.

Ensure uniform distribution of elements across buckets.

Binary Search Tree (BST) Features
Supports generic keys (K extends Comparable<K>) and values (V).

Internal Node class holds key-value pairs.

Operations:

put(K key, V val)

get(K key)

delete(K key)

iterator() for in-order traversal (non-recursive).

Added a size attribute to track the number of elements.

During iteration, both key and value can be accessed.

Example Usage
java
Копировать
Редактировать
for (var elem : bst) {
    System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
}
How to Run
Compile all .java files:

bash
Копировать
Редактировать
javac *.java
Run your test class containing main():

bash
Копировать
Редактировать
java Main
Notes
No recursion used in BST.

No Objects.hash() or similar utilities allowed in MyHashTable.

Focused on manual data structure implementation and understanding core logic.

Clean and optimized hashing for minimizing collisions.
