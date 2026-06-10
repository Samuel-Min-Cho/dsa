package sorting;

public class integersorts {

  private integersorts(){}

  // counting sort
  public static void countingSort (int[] a) {
    int min = a[0], max = a[0];
    for (int v : a){
      if (v < min) min = v;
      if (v > max) max = v;
    }

    int range = max - min + 1;
    int[] count = new int[range];
  }

  // radix sort
  public static void radixSort (int[] a){

  }

  // bucket sort
  public static void bucketSort (int[] a){

  }
}
