package sorting;

public class heapsort implements sorter {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] a) {}

    @Override
    public String name() {
        return "heap: ";
    }
}
