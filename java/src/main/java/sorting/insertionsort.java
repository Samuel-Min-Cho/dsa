package sorting;

public class insertionsort extends abstractor {
  @Override
  public <T extends Comparable<? super T>> void doSort(T[] a) {
    int n = a.length;
    for (int i = 1; i < n; i++) {
      T key = a[i];
      int j = i - 1;

      // key < a[j]
      while (j >= 0 && sorter.less(key, a[j])) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = key;
    }
  }

  @Override
  public String name() {
    return "insertion: ";
  }
}
