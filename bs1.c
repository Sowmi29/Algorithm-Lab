#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

void optimizedBubbleSort(int *arr, int n)
{
    bool swap;
    int count = 0;
    for (int i = 0; i < n - 1; i++)
    {
        count += 2;
        swap = false;
        for (int j = 0; j < n - i - 1; j++)
        {
            count++;
            if (arr[j] > arr[j + 1])
            {
                count += 4;
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swap = true;
            }
        }
        count += 2;
        if (swap == false)
            break;
    }
    printf("Count value in optimized: %d\n", count);
}

void bubbleSort(int arr[], int n)
{
    int count = 0;
    for (int i = 0; i < n - 1; i++)
    {
        count++;
        for (int j = 0; j < n - i - 1; j++)
        {
            count++;
            if (arr[j] > arr[j + 1])
            {
                count += 3;
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    printf("Count value in non-optimized: %d\n", count);
}

void print(int *arr, int n)
{
    for (int i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main()
{
    int n;
    printf("Size of array? \n");
    scanf("%d", &n);
    int arr[n], originalArr[n];
    printf("generating array elements: \n");
    for (int i = 0; i < n; i++)
    {
        arr[i] = rand() % 100;
        originalArr[i] = arr[i];
    }
    printf("original array : \n");
    print(arr, n);
    bubbleSort(arr, n); 

    memcpy(arr, originalArr, n * sizeof(int)); 
    optimizedBubbleSort(arr, n);               

    print(arr, n); 
    return 0;
}
