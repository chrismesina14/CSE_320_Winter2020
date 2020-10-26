import numpy as rand
import datetime

start = datetime.datetime.now()

def partition(arr, low, high):
        i = (low - 1)            # index of smaller element 
        pivot = arr[high]        # pivot 

        for j in range(low, high):

                # If current element is smaller than or equal to pivot 
                if arr[j] <= pivot:

                        # increment index of smaller element 
                        i += 1
                        arr[i], arr[j] = arr[j], arr[i]

        arr[i + 1], arr[high] = arr[high], arr[i + 1]
        return (i + 1)

# Function to do Quick sort 
def quickSort(arr, low, high):
        if low < high:

                # pi is partitioning index, arr[p] is now at right place 
                pi = partition(arr, low, high)

                # Separately sort elements before partition and after partition 
                quickSort(arr, low, pi-1)
                quickSort(arr, pi + 1, high)

# Driver Code 
if __name__ == '__main__' :

        # Generates arrays of 1000 3 or 4 digit integers using numpy
        arr = rand.random.randint(100, high = 10000, size = 1000)
        n = len(arr)

        # Calling quickSort function 
        quickSort(arr, 0, n - 1)

        for i in range(n):
                print(arr[i], end = " ")

        finish = datetime.datetime.now()
        print('\nElapsed time: ', finish-start)
