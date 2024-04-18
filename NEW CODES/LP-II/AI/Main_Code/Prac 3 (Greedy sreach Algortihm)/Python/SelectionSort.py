def selectionSort(arr):
    n = len(arr)

    for i in range(n-1):
        min_idx = i
        for j in range(i+1, n):
            if arr[j] < arr[min_idx]:
                min_idx = j

        arr[min_idx], arr[i] = arr[i], arr[min_idx]

n = int(input("Enter the size of the input: "))
arr = []
print("Enter the elements of the array:")
for i in range(n):
    element = int(input("Enter the {} element: ".format(i+1)))
    arr.append(element)

print("Unsorted array:")
for num in arr:
    print(num, end=" ")

selectionSort(arr)

print("\nSorted array:")
for num in arr:
    print(num, end=" ")

"""
Enter the size of the input: 5
Enter the elements of the array
Enter the 1 element: 64 
Enter the 2 element: 25
Enter the 3 element: 12
Enter the 4 element: 23
Enter the 5 element: 16
Unsorted array:
64 25 12 23 16 
Sorted array:
12 16 23 25 64
"""