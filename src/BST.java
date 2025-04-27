import java.util.Iterator;
import java.util.LinkedList;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size = 0;

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        Node newNode = new Node(key, val);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }

        if (key.compareTo(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;
    }

    public V get(K key) {
        Node current = root;

        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node parent = null;
        Node current = root;

        while (current != null && !current.key.equals(key)) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) return;
        if (current.left == null || current.right == null) {
            Node newCurrent = (current.left == null) ? current.right : current.left;

            if (parent == null) {
                root = newCurrent;
            } else if (current == parent.left) {
                parent.left = newCurrent;
            } else {
                parent.right = newCurrent;
            }
            size--;
        }
        else {
            Node p = null;
            Node temp = current.right;

            while (temp.left != null) {
                p = temp;
                temp = temp.left;
            }

            if (p != null) {
                p.left = temp.right;
            } else {
                current.right = temp.right;
            }

            current.key = temp.key;
            current.val = temp.val;
            size--;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<Entry<K, V>> {
        private LinkedList<Node> stack = new LinkedList<>();

        public BSTIterator() {
            Node current = root;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Entry<K, V> next() {
            Node node = stack.pop();
            Entry<K, V> entry = new Entry<>(node.key, node.val);

            if (node.right != null) {
                Node temp = node.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
            return entry;
        }
    }
}
