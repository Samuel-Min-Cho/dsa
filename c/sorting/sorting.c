#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


// Sorting in ARRAY Data Structure

void display(int arr[], int size){
    for (int i = 0 ; i < size ; i ++){
        printf("%d ", arr[i]);
    }
    printf ("\n");
}
void copy_arr (int * arr,  int * arr_copy , int size){
    memcpy (arr_copy, arr, sizeof(int) * size);
    printf("Before: ");
    display(arr_copy, size);
}

void swap (int arr [],int a , int b){
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

int biggest (int * arr, int size){
    int big = arr[0];
    for (int i = 0 ; i < size ; i ++){
        if ( big < arr[i] ){
            big = arr[i];
        }
    }
    return big;
}

// Algo ----------------------------------------------------------
/* bubble_sort
   Compares q vs q+1 -> swap if q > q+1
   Sorts the biggest to the end of the array
   Starts from the index 0 for all the iteration, stops at size-i (i = # iteration)
   */
void bubble_sort (int arr [], int size ){
    int arr_copy[size];
    copy_arr (arr, arr_copy, size);

    for (int i = 0 ; i < size ; i ++){
        for (int q = 0; q < size-i ; q ++){
            if (arr_copy[q] > arr_copy[q+1]){
                swap (arr_copy, q, q+1);
            }
        }
        display (arr_copy, size);
    }
    printf("\n");
}

/* selection_sort
   Each iteration #  = index for the next smallest element in the array
   finding the smallest element in the array -> swap with i
   */
void selection_sort (int * arr, int size){

    int arr_copy [size];
    copy_arr (arr, arr_copy, size);

    for (int i = 0 ; i < size ; i ++){
        int smallest = i;
        for (int q = i + 1; q < size; q++){
            if (arr_copy[smallest] > arr_copy[q]){
                smallest = q;
            }
        }
        swap (arr_copy, smallest, i);
        display(arr_copy, size);
    }
    printf("\n");
}

/* insertion_sort
   Comparing the curent index element  with the elements on the left (backward tracing)
   = start from 1 not 0
   Finding the proper place of the current index element from the already-sorted array
   My approach: Swapping -> Too many writes (unnecessary writes)
Solution: Shift q-1 to q if q < q-1 else overwrite on it
*/
void insertion_sort(int * arr, int size){

    int arr_copy [size];
    copy_arr(arr, arr_copy, size);

    // swap approach : higher mem traffic (too many writes)
    /*
       for (int i = 1 ; i < size ; i ++){
       for (int q = i; q > 0 ; q -- ){
       if (arr_copy[q-1] > arr_copy[q]){
       swap (arr_copy, q-1,q );
       display(arr_copy, size);
       }else{
       break;
       }
       }
       }
       */

    // shifting approach : canonical
    for (int i = 1 ; i < size ; i ++){
        int temp = arr_copy[i];
        int place = i;
        for (int q = i; q > 0 ; q --){
            if (temp < arr_copy[q-1]){
                arr_copy[q] = arr_copy[q-1];
                place = q-1;
            }else {
                break;
            }
        }
        arr_copy[place] = temp;
        display(arr_copy, size);
    }
    printf("\n");
}

/* quick_sort
    Divide and Conquer -> left and right until start < end
    Sorting the i <= pivot on the left
    new_pivot = where pivot should be placed
    My approach: finding the first bigger element & using it to compare with others
        No need to sort i > pivot elements
        Disregarding i = pivot elements
    Solution: swap to sort i < pivot elements to the left
        Think it as allocating the space for i < pivot elements
        Then swap (pivot , new_pivot + 1)
*/
int partition (int * arr_copy, int size, int low, int high){
    // Canonical: disregarding temp & arr[i]
    int pivot = arr_copy [high];
    int new_pivot = low -1;

    for (int i = low ; i < high ; i++){
        if (arr_copy[i] <= pivot){ // i < pivot -> locate it on the left
            new_pivot ++;
            swap (arr_copy, i, new_pivot);
        }
    }
    swap (arr_copy, ++new_pivot , high); //new_pivot+1 = first bigger than pivot
    display(arr_copy, size);

    return new_pivot;

    // My approach: Using the first bigger element to compare among the elements
    // int new_pivot = high; // New_Pivot INDEX
    // int temp = low; // first bigger element INDEX
    // int pivot = arr_copy[high]; // pivot = arr[high] VALUE
    // // Finding the first bigger element
    // while (low < high){ // Low -> High traverse
    //     if (pivot < arr_copy[low]){ // temp & new_pivot = index of first bigger
    //         temp = low;
    //         new_pivot = low;
    //         low++;
    //         break;
    //     }
    //     low++;
    // }
    // // Swapping if necessary
    // while (low < high){ // Continuous low value from the above while loop
    //     if (pivot >  arr_copy[low]){  // swap first bigger & arr[low] < pivot
    //         swap(arr_copy, temp, low);
    //         temp ++ ;
    //         new_pivot ++;
    //     }else if (pivot < arr_copy[low]) { // temp > low > pivot -> swap(temp & low)
    //         if (arr_copy[temp] > arr_copy[low]){
    //             swap(arr_copy, temp, low);
    //         }
    //          // temp & new_pivot stays
    //     }
    //     low ++;
    // }
    // swap(arr_copy, new_pivot, high);
    // display(arr_copy, size);
    // return new_pivot;
}
void quick_sort(int * arr_copy, int size, int start,  int end){
    int pivot = end;
    // if (pivot >= start && pivot = end){
    if (start < end){
        pivot = partition (arr_copy, size, start, end);
        quick_sort (arr_copy, size, start, pivot-1);
        quick_sort (arr_copy, size,  pivot+1, end);
    }
}

/* count_sort
    Conditions: non-negative ints / discrete size & values
    Index of an array = value of the number
    Find the biggest number -> max size of count array
   */
void count_sort(int * arr, int size){
    // 1) Find the biggest num
    int big = biggest(arr, size);
    printf("big: %d\n", big);

    // 2) Initialize count array
    int *count = (int*)malloc ((big+1) * sizeof(int));
    memset (count, 0, (big+1)*sizeof(int));

    // 3) stacking count
    for (int i = 0 ; i < size; i++){
        count[arr[i]]++;
    }
    printf("count: ");
    display(count, big+1);

    // 4) sorting
    int l = 0;
    for (int q = 0; q <= big; q++){
        for (int c = count[q]; c > 0; c--){
            arr[l] = q;
            l++;
        }
    }
    display(arr, size);
    free(count);
}

/* radix_sort
   Sorts the array by the order of each digits - starting from digit 1
   Must be stable sort -> consider the previous sorting process
   If it is unstalbe -> disregard the previous sorting and only focus on the current digit
   Core = arr[i] % 10^d / 10^(d-1), d = digit
   Potential risk: Mem waste
   Could malloc the exact amount of bucket, but it's a trade-off btw mem and run time
   since it requires another loops
   */
void radix_sort(int * arr, int size){

    // 1) find the biggest
    int big = arr[0];
    for (int i = 1 ; i <  size ; i++){
        if (arr[i] > big){
            big = arr[i];
        }
    }
    int e = 10;
    int digits = 1;
    int big_copy = big;
    do{
        big_copy = big_copy / e;
        e = e * 10;
        digits++;
    }while(big_copy > 0 );
    printf("big: %d, digits: %d\n", big, digits);

    // 2) Sort
    int count [10] = {0};
    int * bucket [10]; // array of pointers
    for (int i = 0 ; i < 10 ; i ++ ){
        bucket[i] = malloc(size * sizeof(int));
    }
    // sorting by the order of each digit
    // % by 10^d then / by d-1
    for (int d = 1 ; d <= digits ; d ++){
        for (int i = 0 ; i < size ; i++){
            int exp2 = (int) pow (10 , d-1);
            if (arr[i] / exp2 < 1){
                bucket[0][count[0]] = arr[i];
                count[0]++;
            }else{
                int exp1 = (int) pow (10, d);
                int num = arr[i] % exp1 / exp2;
                printf("%d ", num);
                bucket[num][count[num]] = arr[i];
                count[num]++;
            }
        }
        printf("\ncount: ");
        display(count, 10);
        // re-ordering an arry
        // FIFO for count array
        // Smallest to Biggest for arr re-ordering
        int index = 0 ;
        for (int i = 0; i < 10; i ++){
            for (int c = 0 ; c <  count[i]; c++){
                arr[index] = bucket[i][c];
                index++;
            }
            count[i] = 0;
        }
        printf("digit %d: ", d);
        display(arr,size);
    }
    printf("Final: ");
    display(arr,size);

    // free malloc
    for (int i = 0 ; i < 10 ; i ++){
        free (bucket[i]);
    }
}

// merge_sort
void sort (int *arr, int size, int left_start, int left_end, int right_start, int right_end){
    int left_size = left_end - left_start + 1;
    int right_size = right_end - right_start + 1;

    int left [left_size];
    int left_index = 0;
    for (int l = left_start; l <= left_end; l++){
        left[left_index] = arr[l];
        left_index++;
    }
    int right [right_size];
    int right_index = 0;
    for (int r = right_start; r <= right_end; r++){
        right[right_index] = arr[r];
        right_index++;
    }

    left_index = 0, right_index = 0;
    for (int i = left_start; i <= right_end; i ++){
        if (left_index >= left_size){
            arr[i] = right[right_index];
        }else if(right_index >= right_size){
            arr[i] = left[left_index];
        }else if (left[left_index] < right[right_index]){
            arr[i] = left[left_index];
            left_index++;
        }else{
            arr[i] = right[right_index];
            right_index++;
        }
    }
    display(arr, size);
}
void merge_sort (int *arr , int size, int start, int end){
    int mid = (start + end) / 2 ;
    while (start < mid ||  mid < end ){
        printf("mid: %d\n",mid);
        merge_sort (arr, size, start, mid);
        merge_sort (arr, size, mid+1, end);
        sort(arr, size, start, mid, mid+1, end);
        break;
    }
}

// Linear Search
// Traverse all the elements in the array to find a value
// Return index if value is found, else return -1
int linear_search (int arr[], int size, int val){
    for (int i = 0 ; i < size; i ++){
        if (arr[i] == val){
            return i;
            break;
        }
    }
    return -1;
}

// Binary Search
// Find the middle of the array & compare with the value
// If val < middle -> left || val > middle -> right
// val == mid : index = mid_index
int binary_search (int arr[], int size, int val, int start, int end){
    int mid_index = (start + end) / 2;
    int mid = arr[mid_index] ;
    int index = -1 ;
    printf("mid: %d\n", mid);
    while (start <=  mid_index && mid_index <= end){
        if (val == mid){
            index = mid_index;
        }else if(val < mid){
            index = binary_search (arr, size, val, start, mid_index-1);
        }else if (mid < val){
            index = binary_search (arr, size, val, mid_index+1, end);
        }
        break;
    }
    return index;
}

int main (){
    /* Sorting Algorithms
       int arr0[] = {7, 12, 9, 11, 3};
       int size0 = sizeof(arr0) / sizeof(arr0[0]);
       int arr0_copy [size0];
       int arr [] = {
       7, 7,                   // duplicates
       100, 1,                 // big > pivot early, small late
       50, 49, 48, 47,         // descending block
       2, 99,                  // small followed by huge
       3, 3, 3,                // triple duplicates
       88, 5, 88,              // duplicates + big around small
       0,                      // smallest possible
       50,                     // mid pivot-repeated
       200,                    // absolute large outlier
       6, 4, 10,               // small ascending block
       10, 10,                 // equal-to-pivot cluster
       9, 8, 7                 // near-pivot values
       };
       int size = sizeof(arr) / sizeof(arr[0]);
       int arr_copy [size];
       printf("bubble_sort: \n");
       bubble_sort (arr, size);

       printf("selection_sort: \n");
       selection_sort(arr,size);

       printf("insertion_sort:\n");
       insertion_sort(arr,size);

       printf("quick_sort:\n");
       int arr_copy [size];
       copy_arr (arr, arr_copy, size);
       quick_sort(arr_copy, size, 0, size-1);
       display(arr_copy, size);

       printf("counting_sort: \n");
       int arr3 [] ={4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3};
       int size3 = sizeof(arr3) / sizeof(arr3[0]);
       int arr3_copy [size3];
       copy_arr(arr3, arr3_copy, size3);
       count_sort(arr3_copy, size3);

       printf("radix_sort: \n");
    // int arr4 [] = {170, 45, 75, 90, 802, 24, 2, 66};
    // int size4 = sizeof(arr4) / sizeof(arr4[0]);
    // int arr4_copy [size4];
    // copy_arr (arr4, arr4_copy, size4);
    // radix_sort(arr4_copy, size4);
    copy_arr (arr, arr_copy, size);
    radix_sort(arr_copy, size);

    printf("merge_sort: \n");
    copy_arr (arr, arr_copy, size);
    merge_sort(arr_copy, size, 0 , size-1);
    // copy_arr (arr0, arr0_copy, size0);
    // merge_sort(arr0_copy, size0, 0, size0-1);
    */


    // Searching Algo
    // Unsorted / Mix of + & - / reasonable size (20) / duplicates
    int arr [] = {42, -15, 7, 23, -15, 0, 99, 7, 1, 156, -3, 42, 88, 7, 5, 42, 201, -15, 67, 42};
    int size = sizeof(arr) / sizeof(arr[0]);

    // Linear Search
    printf("Linear_search (1): %d\n\n", linear_search (arr, size, 1));

    // Binary Search
    int arr_copy [20];
    copy_arr(arr, arr_copy, size);
    printf("binary_search: \n");
    quick_sort(arr, size , 0, 19);
    printf("End of quick_sorting\n");
    printf("Binary_search (1): %d\n", binary_search(arr, size, 1, 0, 19));
    printf("Binary_search (N/A): %d\n", binary_search(arr, size, 3, 0, 19));
}


