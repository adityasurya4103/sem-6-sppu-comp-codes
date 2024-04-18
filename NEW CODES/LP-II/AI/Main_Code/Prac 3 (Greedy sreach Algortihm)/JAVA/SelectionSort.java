import java.util.*;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[]) {
        Scanner in= new Scanner(System.in);
        System.out.print("Enter the size of the input: ");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the "+(i+1)+" element: ");
            arr[i]=in.nextInt();
        }
        System.out.println("Unsorted array:");
        for (int i = 0; i <n; i++) {
            System.out.print(arr[i] + " ");
        }
        selectionSort(arr);
        System.out.println("\nSorted array:");
        for (int i = 0; i <n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
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
*/