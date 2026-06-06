package sorting;

import java.util.Arrays;

public class selectionsort extends abstractor {

  @Override
  public <T extends Comparable<? super T>> void doSort(T[] a) {
    int n = a.length;

    for (int i = 0; i < n; i++) {
      int smallest = i;
      for (int j = i + 1; j < n; j++) {
        if (sorter.less(a[j], a[smallest])) smallest = j;
      }
      if (i != smallest) sorter.swap(a, i, smallest);
      System.out.println(Arrays.toString(a));
    }
  }

  @Override
  public String name() {
    return "selection: ";
  }
}
