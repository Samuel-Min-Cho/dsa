package sorting;

import java.util.Arrays;
import java.util.Random;

public class main_sorting {

  private static Integer[] randomBoxed(int n) {
    Random rnd = new Random(42);
    Integer[] a = new Integer[n];
    for (int i = 0; i < n; i++) a[i] = rnd.nextInt(100);
    return a;
  }

  public static void main(String argc[]) {

    System.out.println("=== Primitive sorts (non-comparison) ===");
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
  }
}
