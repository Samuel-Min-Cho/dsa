import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class array_list {
  public static void main(String argc[]) {
    // array -------------------------------------
    int[] nums = new int[5];
    int[] primes = {2, 3, 5, 7, 11};
    int[][] matrix = new int[3][4]; // rows, colms
    nums[0] = 42;
    int x = primes[2];
    Arrays.sort(primes); // O(nlogn)
    Arrays.fill(nums, -1);
    int[] copy = Arrays.copyOf(primes, 3); // [3, 5, 7]
    int idx = Arrays.binarySearch(primes, 7); // O(log n) must be sorted
    Arrays.toString(nums);

    // ArrayList -----------------------------------
    List<String> names = new ArrayList<>();
    ArrayList<String> names2 = new ArrayList<>(Arrays.asList("John", "Kayle"));
    // ArrayList<String> names2 = new ArrayList<String>("Jhon", "Kayle"); ->
    // CANNOT explicitly assign the values
    names.add("John"); // O(1) amortized: gradually reducing
    names.add(0, "kayle"); // O(n) right shift
    names.remove(1); // O(n) left shift
    String first = names.get(0);
    names.sort(Comparator.naturalOrder()); // O(nlogn)
    boolean has = names.contains("Alice"); // O(n) linear search

    // LinkedList
    LinkedList<Integer> ll = new LinkedList<>();
    ll.addFirst(1); // add to head
    ll.addLast(2); // add to tail
    ll.removeFirst();
    Integer k = ll.get(3);
  }
}
