package sorting;

public abstract class abstractor implements sorter {

  @Override
  public <T extends Comparable<? super T>> void sort(T[] a) {
    if (a == null) {
      throw new IllegalArgumentException("null array");
    } else if (a.length < 2) {
      return;
    }
    doSort(a);
  }

  // abstract method declaration
  protected abstract <T extends Comparable<? super T>> void doSort(T[] a);
}
