package sorting;

import java.util.Arrays;

public class quicksort extends abstractor {
  @Override
  public <T extends Comparable<? super T>> void doSort(T[] a) {
    int n = a.length;
    System.out.println(Arrays.toString(a));
    T[] b = Arrays.copyOf(a, n);
    System.out.println("LUMOTO:");
    lumoto_sort(a, 0, n - 1);
    System.out.println("HOARE:");
    hoare_sort(b, 0, n - 1);
  }

  private <T extends Comparable<? super T>> void hoare_sort(T[] a, int low, int high) {
    while (low < high) {
      int p = hoare_partition(a, low, high);
      System.out.println(
          "partition: " + p + ", high/low: " + high + "/" + low + ", " + Arrays.toString(a));

      // lower elements side -> recursion
      if (p - low < high - p) {
        hoare_sort(a, low, p); // sorts entire left
        low = p + 1; // not exclude partition
      } else {
        hoare_sort(a, p + 1, high); // sort the entire right
        high = p; // incldue partition so no p-1;
      }
    }
  }

  private <T extends Comparable<? super T>> int hoare_partition(T[] a, int low, int high) {
    int mid = low + (high - low) / 2;

    // median of low / mid / high
    // put the median at high
    if (sorter.less(a[mid], a[low])) sorter.swap(a, low, mid);
    if (sorter.less(a[high], a[low])) sorter.swap(a, high, low);
    if (sorter.less(a[high], a[mid])) sorter.swap(a, high, mid);
    System.out.println("median: " + Arrays.toString(a));

    T pivot = a[mid];
    int i = low - 1;
    int j = high + 1;

    while (true) {
      do i++;
      while (sorter.less(a[i], pivot));
      do j--;
      while (sorter.less(pivot, a[j]));
      if (i >= j) {
        return j;
      }
      sorter.swap(a, i, j);
    }
  }

  private <T extends Comparable<? super T>> void lumoto_sort(T[] a, int low, int high) {
    while (low < high) {
      int p = lumoto_partition(a, low, high);
      System.out.println(
          "partition: " + p + ", high/low: " + high + "/" + low + ", " + Arrays.toString(a));
      // lower elements side -> recursion
      if (p - low < high - p) {
        lumoto_sort(a, low, p - 1); // exclude partition
        low = p + 1;
      } else {
        lumoto_sort(a, p + 1, high); // exclude partition
        high = p - 1;
      }
    }
  }

  private <T extends Comparable<? super T>> int lumoto_partition(T[] a, int low, int high) {
    int mid = low + (high - low) / 2;

    // median of low / mid / high
    // put the median at high
    if (sorter.less(a[mid], a[low])) sorter.swap(a, low, mid);
    if (sorter.less(a[high], a[low])) sorter.swap(a, high, low);
    if (sorter.less(a[high], a[mid])) sorter.swap(a, high, mid);
    sorter.swap(a, mid, high);
    System.out.println("median: " + Arrays.toString(a));

    T pivot = a[high];
    int i = low;

    for (int j = low; j < high; j++) {
      if (sorter.less(a[j], pivot)) {
        sorter.swap(a, i++, j);
      }
    }
    sorter.swap(a, i, high);
    return i;
  }

  @Override
  public String name() {
    return "quick: ";
  }
}
