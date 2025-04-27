# MyHashTable and BST Implementation

## MyHashTable<K, V>

Custom Hash Table implementation using chaining with linked lists.

### Features:
- Generic key-value storage: `<K, V>`.
- Collision handling via linked list (`HashNode<K, V>`).
- Methods implemented:
  - `void put(K key, V value)`
  - `V get(K key)`
  - `V remove(K key)`
  - `boolean contains(V value)`
  - `K getKey(V value)`
- Custom `hash(K key)` method (no `Objects.hash()` or similar).
- Default bucket size: `11`.
- Dynamic size tracking.

### Testing:
- Created `MyTestingClass`:
  - Implements custom `hashCode()` method.
  - Ensures uniform hash distribution.
- Inserted `10,000` random elements.
- Printed the number of elements per bucket.

### Example Test:
```java
MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
for (int i = 0; i < 10000; i++) {
    table.put(new MyTestingClass(...), new Student(...));
}
// Printing number of elements in each bucket
for (int i = 0; i < 11; i++) {
    int count = 0;
    var head = table.getChainArray()[i];
    while (head != null) {
        count++;
        head = head.next;
    }
    System.out.println("Bucket " + i + ": " + count + " elements");
}
