import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class maps_sets {
    public static void main(String argc[]) {
        // MAPs --------------------------------------------------
        // HashMap
        Map<String, Integer> freq = new HashMap<>();

        // count char freq
        for (char c : "helloWorld".toCharArray()) {
            freq.merge(c + " ", 1, Integer::sum);
        }
        freq.getOrDefault("z", 0); // safe get - retuns 0 if absent
        freq.putIfAbsent("a", 1); // insert only if key note present

        // Iterate entires
        freq.forEach((k, v) -> System.out.println(k + " -> " + v));

        // LinkedHashMap: insertion order preserved
        Map<String, Integer> ordered = new LinkedHashMap<>();

        /// TreeMap: sorted by a key
        Map<String, Integer> sorted = new TreeMap<>();

        // SETS -------------------------------------------------------
        // HashSets
        Set<String> seen = new HashSet<>(); // Store unique elements only
        seen.add("Alice");
        seen.add("Alice"); // duplicate -> silently ignoreed
        seen.contains("Bob"); // faster than List.contains

        // Set operations
        Set<Integer> a = new HashSet<>(Set.of(1, 2, 3, 4));
        Set<Integer> b = new HashSet<>(Set.of(3, 4, 5, 6));
        a.retainAll(b); // keeps elements in a & b, removes elements in a that are not in B -> a = {3,4}
        a.addAll(b); // union a = {3,4,5,6}
        a.removeAll(b); // diff

        // TreeSet: sorted & navigable
        TreeSet<Integer> ts = new TreeSet<>(Set.of(5, 1, 3));
        ts.first(); // 1
        ts.last(); // 5
        ts.floor(4); // 3 <= 4
        ts.ceiling(4); // 5 >= 4
    }
}
