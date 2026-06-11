package sorting;

import java.util.function.Supplier;

public enum algorithm {
  bubble(bubblesort::new),
  merge(mergesort::new),
  selection(selectionsort::new),
  insertion(() -> new insertionsort()),
  shell(shellsort::new),
  quick(quicksort::new),
  heap(heapsort::new);

  // functional interface that calls the constructor when .get is invoked
  private final Supplier<sorter> factory;

  algorithm(Supplier<sorter> factory) {
    this.factory = factory;
  }

  public sorter create() {
    // triggers and returns a new instance of that sorter
    return factory.get();
  }
}
