package sorting;

public interface sorter {
  // type parameter declaration: constrain T
  // <T extneds Comparable>: T must be a type that implements (inherits) the
  // comparable interface
  // <? super T>: T DN have to be comparable to itself specifically but,
  // T must implement Comparable<U> where U is T || any ancestor (inheritance)
  // T must have compareTo<T> method available in its or parent class
  <T extends Comparable<? super T>> void sort(T[] array);

  // String extends Comparable<String>

  String name();

  // helpers ----------------------------------------------------------------
  static <T extends Comparable<? super T>> boolean less(T a, T b) {
    // a - b < 0 = a < b = true
    // a > b = false
    return a.compareTo(b) < 0;
  }

  static <T> void swap(T[] array, int i, int j) {
    T tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
