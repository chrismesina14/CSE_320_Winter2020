#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void quick_sort(int arr[], int left, int right) {
    int i, j, pivot;
    i = left;
    j = right;
    pivot = arr[(left + right) / 2];
    int temp;
    
    while (i <= j) {
        while (arr[i] < pivot)
            i++;
        while (arr[j] > pivot)
            j--;

        if (i <= j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
        if (left < j)
            quick_sort(arr, left, j);
        if (i < right)
            quick_sort(arr, i, right);
    }
}

void print_arr(int arr[]) {
    
    for (int i = 0; i < 1000; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main(int argc, const char * argv[]) {
    
    int or_arr[1000];
    srand(0);
    for(int i = 0; i < 1000; i++)
    {
        or_arr[i] = rand() % 1000 + 100;
    }
    
    printf("Before quicksort: ");
    print_arr(or_arr);
    
    clock_t begin = clock();

    quick_sort(or_arr, 0, 999);
    
    clock_t end = clock() - begin;

    printf("\nAfter quicksort: ");
    print_arr(or_arr);
    
    double time_elapsed = ((double) end) / CLOCKS_PER_SEC; 
    printf("Elapsed time is: %f seconds \n", time_elapsed);

    return 0;
}

