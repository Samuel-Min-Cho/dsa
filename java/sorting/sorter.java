package sorting;

public interface sorter {
    // type parameter declaration: constrain T
    // <T extneds Comparable>: T must be a type that implements (inherits) the
    // Comparable interface
    // <? super T>: T DN have to be comparable to itself specifically
    // T must implement Comparable<U> where U is T || any ancestor (inheritance)
    // Override on each sorting class 
    <T extends Comparable<? super T>> void sort(T[] array);

    String name();

    String avgComp();

    String worstComp();

    boolean isStable();

    // helpers
    static <T extends Comparable<? super T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0; // a - b < 0
    }

    static <T extends 
}
