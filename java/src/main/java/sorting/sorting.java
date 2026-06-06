package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class sorting {

  // mergesort
  static void merge(int[] a, int low, int mid, int high) {
    // size of subarrays
    int n1 = mid - low + 1; // include mid
    int n2 = high - mid;    // exclude mid
    // temp array
    int[] L = new int[n1];
    int[] R = new int[n2];

    // copy data
    for (int i = 0; i < n1; i++)
      L[i] = a[low + i];
    for (int j = 0; j < n2; j++)
      R[j] = a[mid + 1 + j]; // exclude mid

    // merge
    int i = 0, j = 0, k = low;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        a[k] = L[i];
        i++;
      } else {
        a[k] = R[j];
        j++;
      }
      k++;
    }
    // rest
    while (i < n1) {
      a[k] = L[i];
      i++;
      k++;
    }
    while (j < n2) {
      a[k] = R[j];
      j++;
      k++;
    }
  }

  static void mergeSort(int[] a, int low, int high) {
    if (high - low < 2)
      return;
    int mid = (high + low) / 2;
    mergeSort(a, low, mid);
    mergeSort(a, mid, high);
    merge(a, low, mid, high);

    /*
     * if (low < high) {
     * int mid = low + (high - low) / 2
     * mergesort (low, mid)
     * mergesort (mid + 1, high)
     * merge (low, mid, high)
     * }
     */
  }

  public static void main(String argc[]) {
    // primitives
    int[] arr = {4, 5, 1, 2, 3};
    int[] arr2 = Arrays.copyOf(arr, 5);
    Arrays.sort(arr);
    // System.out.println(arr); // address
    // printing arrayLsit option 1
    System.out.println("Arrays.sort(): " + Arrays.toString(arr));

    Arrays.sort(arr2, 1, 4); // [1..3]
    // printing arrayList option 2
    for (int i : arr2)
      System.out.println(arr2[i]);

    // objects : timsort (stable)
    List<String> names = List.of("charlie", "Bob", "Alice");
    names.sort(Comparator.naturalOrder());
    System.out.println(names);

    // merge
    int[] a = {4, 2, 3, 5, 1};
    mergeSort(a, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }
}
