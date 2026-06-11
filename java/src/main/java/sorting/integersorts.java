package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class integersorts {

  private integersorts() {}

  // counting sort ---------------------------------------
  public static void countingSort(int[] a) {

    // finding min and max
    int min = a[0], max = a[0];
    for (int v : a) {
      if (v < min) min = v;
      if (v > max) max = v;
    }

    // creating count with the size of a range
    int range = max - min + 1;
    int[] count = new int[range];

    // saving into the count array (index = value - min)
    for (int v : a) {
      count[v - min]++;
      System.out.println("count_before : " + Arrays.toString(count));
    }

    // reserving the spots for previous #
    for (int i = 1; i < range; i++) {
      count[i] += count[i - 1];
      // System.out.println("count : " + Arrays.toString(count));
    }

    int[] out = new int[a.length];
    // starting from the end of the array
    for (int i = 0; i < a.length; i++) {
      // a[i] - min : count index
      // count(a[i] - min) : _th in out
      // --count(a[i] - min) : out index
      System.out.println(a[i] + ": " + (a[i] - min) + ", " + (count[a[i] - min] - 1));
      out[--count[a[i] - min]] = a[i];
      System.out.println("count : " + Arrays.toString(count));
      System.out.println("out : " + Arrays.toString(out));
    }
    System.arraycopy(out, 0, a, 0, a.length);
  }

  // radix sort : base 10  ------------------------------------------
  public static void radixSort(int[] a) {
    List<Integer> neg = new ArrayList<>();
    List<Integer> pos = new ArrayList<>();
    for (int v : a) {
      if (v < 0) neg.add(-v);
      else pos.add(v);
    }

    int[] negArr = neg.stream().mapToInt(Integer::intValue).toArray();
    int[] posArr = pos.stream().mapToInt(Integer::intValue).toArray();

    radixSortNonNegative(negArr);
    radixSortNonNegative(posArr);

    int index = 0;
    // high to low
    for (int i = negArr.length - 1; i >= 0; i--) a[index++] = -negArr[i];
    for (int v : posArr) a[index++] = v;
  }

  private static void radixSortNonNegative(int[] a) {
    if (a.length == 0) return;
    int max = 0;
    for (int v : a) max = Math.max(max, v);

    int[] out = new int[a.length];
    // until max < 10^x = 0
    for (int exp = 1; max / exp > 0; exp *= 10) {
      int[] count = new int[10];
      // mod 10 -> count index
      for (int v : a) count[(v / exp) % 10]++;
      // counter = placement
      for (int i = 1; i < 10; i++) count[i] += count[i - 1];

      //
      for (int i = 0; i < a.length; i++) {
        int digit = (a[i] / exp) % 10;
        out[--count[digit]] = a[i];
      }
      System.arraycopy(out, 0, a, 0, a.length);
    }
  }

  // bucket sort -----------------------------------------

  public static void bucketSort(int[] a) {
    int min = a[0], max = a[0];
    for (int v : a) {
      if (v < min) min = v;
      if (v > max) max = v;
    }
    if (min == max) return;

    int bucketCount = a.length;
    List<List<Integer>> buckets = new ArrayList<>(bucketCount);
    for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

    long range = (long) max - min + 1;
    for (int v : a) {
      int index = (int) ((long) (v - min) * (bucketCount - 1) / (range - 1));
      buckets.get(index).add(v);
    }

    int pos = 0;
    for (List<Integer> bucket : buckets) {
      Collections.sort(bucket);
      for (int v : bucket) a[pos++] = v;
    }
  }
}
