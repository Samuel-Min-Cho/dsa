package sorting;

import java.util.Arrays;

public class shellsort extends abstractor {

  @Override
  public <T extends Comparable<? super T>> void doSort(T[] a) {
    int n = a.length;
    int gap = 1;

    while (gap < n / 3) {
      gap = 3 * gap + 1; // 4, 13, 40, 121
    }

    while (gap >= 1) {
      for (int i = gap; i < n; i++) {
        T key = a[i];
        int j = i;
        while (j >= gap && sorter.less(key, a[j - gap])) {
          a[j] = a[j - gap];
          System.out.println("gap : " + gap + ", j: " + j + ", " + Arrays.toString(a));
          j -= 1;
        }
        a[j] = key;
        System.out.println("gap : " + gap + ", i: " + i + ", " + Arrays.toString(a));
      }
      gap /= 3;
    }
  }

  @Override
  public String name() {
    return "shell: ";
  }
}
