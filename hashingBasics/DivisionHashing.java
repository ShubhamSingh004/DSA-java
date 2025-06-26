import java.util.ArrayList;

public class DivisionHashing {

    // Size of the hash table (ideally a prime number)
    static final int TABLE_SIZE = 7;

    // Each bucket is a list to handle collisions (chaining)
    @SuppressWarnings("unchecked")
    static ArrayList<Integer>[] hashTable = new ArrayList[TABLE_SIZE];

    // Hash function using division method
    static int hashFunction(int key) {
        return key % TABLE_SIZE;
    }

    // Insert a key into the hash table
    static void insert(int key) {
        int index = hashFunction(key);

        // Initialize the bucket if not already created
        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }

        // Insert key into the appropriate bucket
        hashTable[index].add(key);
    }

    // Display the hash table
    static void displayHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Bucket " + i + ": ");

            if (hashTable[i] != null) {
                for (int key : hashTable[i]) {
                    System.out.print(key + " ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] keys = {10, 22, 31, 4, 15, 28, 17, 88, 59};

        // Insert each key using division hashing
        for (int key : keys) {
            insert(key);
        }

        // Display the resulting hash table
        displayHashTable();
    }
}
