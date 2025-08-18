//merge to sorted array
//Input: arr1 = [1, 3, 5], arr2 = [2, 4, 6]
//Output: arr1 = [1, 2, 3], arr2 = [4, 5, 6]
import java.util.Scanner;
public class Array {
    public static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int gap = nextGap(m + n);

        while (gap > 0) {
            int i, j;


            for (i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    swap(arr1, i, i + gap);
                }
            }


            for (j = (gap > m) ? gap - m : 0; i < m && j < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }


            if (j < n) {
                for (j = 0; j + gap < n; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        swap(arr2, j, j + gap);
                    }
                }
            }

            gap = nextGap(gap);
        }
    }


    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40};
        int[] arr2 = {5,15,25,35};

        merge(arr1, arr2);

        System.out.print("arr1 = ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.println();

        System.out.print("arr2 = ");
        for (int x : arr2) System.out.print(x + " ");
    }
}

