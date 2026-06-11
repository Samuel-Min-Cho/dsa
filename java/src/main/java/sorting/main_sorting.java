package sorting;

import java.util.Arrays;
import java.util.Random;

public class main_sorting {

  private static Integer[] randomBoxed(int n) {
    // fixed seeding to 42 / same sequence every run
    Random rnd = new Random(42);
    Integer[] a = new Integer[n];

    // [0, 99]
    for (int i = 0; i < n; i++) a[i] = rnd.nextInt(100);
    return a;
  }

  private static int[] randomInt(int n) {
    // more memory efficient
    Random rnd = new Random();
    int[] a = new int[n];

    // [-100, 100] (201: generates 0 200) (-100 shiftss the whole range down by 100)
    for (int i = 0; i < n; i++) a[i] = rnd.nextInt(201) - 100;
    return a;
  }

  public static void main(String argc[]) {

    System.out.println("Primitive sorts (non-comparison) ===");
    // integersorts.bucketSort(base_prim);
    // integersorts.bucketSort(base_prim);
    Integer[] base = randomBoxed(20);
    Integer[] custom = {4, 3, 5, 1, 2, 7, 6};
    System.out.println("Random Int 20: \n" + Arrays.toString(base) + "\n" + "-".repeat(20));

    for (algorithm algo : algorithm.values()) {
      Integer[] data = base.clone();
      Integer[] dataTwo = custom.clone();
      sorter st = algo.create();
      // sorter st = algorithm.selection.create();
      System.out.println(st.name());
      st.sort(dataTwo);
      System.out.println(Arrays.toString(dataTwo));
      System.out.println("-".repeat(8));
      /*
      st.sort(data);
      System.out.println(Arrays.toString(data));
      System.out.println("-".repeat(8));
      */
    }

    System.out.println("non-comparable ---------------------------");
    int[] base_prim = randomInt(15);
    int[] custom_prim = {4, 3, 5, 1, 2, 7, 6};
    int[] counting = {5, 3, 5, 7, 1, 9, 3, 3};

    /*
    System.out.println("CountingSort:");
    integersorts.countingSort(counting);
    */
    // integersorts.countingSort(base_prim);

    System.out.println("RadixSort:");
    integersorts.radixSort(custom_prim);
    System.out.println(Arrays.toString(custom_prim));
    // integersorts.radixSort(base_prim);

    /*
    System.out.println("BucketSort:");
    integersorts.bucketSort(custom_prim);
    */
    // integersorts.bucketSort(base_prim);
  }
}
