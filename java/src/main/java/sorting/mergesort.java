package sorting;

import java.util.Arrays;

public class mergesort extends abstractor {

  @Override
  @SuppressWarnings("unchecked")
  public <T extends Comparable<? super T>> void doSort(T[] a) {
    T[] aux = (T[]) new Comparable[a.length];
    sort(a, aux, 0, a.length - 1); // a, aux, low, high
  }

  private <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int low, int high) {
    if (low >= high) return;
    int mid = low + (high - low) / 2;
    sort(a, aux, low, mid);
    sort(a, aux, mid + 1, high);
    merge(a, aux, low, mid, high);
  }

  private <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int low, int mid, int high) {
    System.arraycopy(a, low, aux, low, high - low + 1); // src, srcPos, des, desPos, length
    int i = low, j = mid + 1;
    for (int k = low; k <= high; k++) {
      if (i > mid) { // left side done
        a[k] = aux[j++];
      } else if (j > high) {
        a[k] = aux[i++]; // right side done
      } else if (sorter.less(aux[i], aux[j])) { // left < right (aux[j], aux[i]) =
        // reverse order (biggest to smallest)
        a[k] = aux[i++];
      } else { // right < left
        a[k] = aux[j++];
      }
    }
    System.out.println("merge: " + Arrays.toString(a));
  }

  @Override
  public String name() {
    return "mergesort";
  }
}
