# BubbleSort
Swapping side-by-side and sorting the biggest to the end <br>
Worst: O(n^2) <br>
Best(sorted): O(n) <br>
Space: O(1)

``` C
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++) {
        int swapped = 0; // optimization
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                // Swap
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapped = 1;
            }
        }
        if (!swapped) break;
    }
}
```


# SelectionSort
Finding the index of the min element and placing with the element in the front <br>
All: O(n^2) <br>
Spcae: O(1) <br>
Unstable

``` C
void selectionSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++) {
        int minIdx = i;
        for (int j = i+1; j < n; j++) {
            if (arr[j] < arr[minIdx])
                minIdx = j;
        }
        // Swap
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}
```

# InsertionSort
Using the Key and placing it in the correct index <br>
Worst: O(n^2) <br>
Best(nearly-sorted): O(n) <br>
Space: O(1) <br>
Stable 


``` C
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        // Shift larger elements to the right
        while (j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
}
```

# QuickSort 

Best/Average: O(n log n) <br>
Worst: O(n²) <br>
Space: O(log n) stack (tail-recursion) <br>
Not stable

``` C 
int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // pivot
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            // Swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    // Final pivot swap
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;
    return i+1;
}

void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high); // pivot index
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```
