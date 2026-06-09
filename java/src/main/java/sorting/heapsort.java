package sorting;

import java.util.Arrays;

public class heapsort implements sorter {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] a) {
        int n = a.length;

        // build heap: biggest to the root (index 0)
        for (int i = n/2 -1 ; i >= 0; i--) siftDown(a, i, n);

        // extract max
        for (int end = n -1; end > 0 ; end--){
            sorter.swap(a, 0, end);
            System.out.println(Arrays.toString(a));
            siftDown(a, 0, end);
        }
    }

    public <T extends Comparable<? super T>> void siftDown(T[] a, int i , int n){
        while (true){
            int l= 2*i + 1, r = 2*i+2, larg = i;

            if (l < n && sorter.less(a[larg], a[l])) larg = l;
            if (r < n && sorter.less(a[larg],a[r])) larg = r;
            if (larg == i) break;

            sorter.swap(a, i, larg);
            System.out.println(Arrays.toString(a));
            // set index to the larg
            i = larg;
        }
    }

    @Override
    public String name() {
        return "heap: ";
    }
}
