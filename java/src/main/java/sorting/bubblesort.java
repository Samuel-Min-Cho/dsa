package sorting;

public class bubblesort extends abstractor {

  @Override
  public <T extends Comparable<? super T>> void doSort(T[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      boolean swap = false;
      for (int j = 0; j < n - 1 - i; j++) {
        if (sorter.less(a[j + 1], a[j])) {
          sorter.swap(a, j, j + 1);
          swap = true;
        }
      }
      if (!swap) break;
    }
  }

  @Override
  public String name() {
    return "bubblesort";
  }
}
