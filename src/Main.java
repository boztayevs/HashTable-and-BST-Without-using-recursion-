import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String name = "Name" + random.nextInt(100000);
            MyTestingClass key = new MyTestingClass(id, name);
            Student student = new Student("Student" + i, random.nextInt(30) + 10);
            table.put(key, student);
        }

        for (int i = 0; i < 11; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, Student>.HashNode<MyTestingClass, Student> head = table.getChainArray()[i];
            while (head != null) {
                count++;
                head = head.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }

        BST<Integer, String> tree = new BST<>();
        tree.put(5, "five");
        tree.put(2, "two");
        tree.put(8, "eight");
        tree.put(1, "one");
        tree.put(3, "three");
        System.out.println("Tree size: " + tree.size());
        for (var elem : tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
