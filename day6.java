//find all subarrays with sum zero
//Input: [1, 2, -3, 3, -1, 2]
//output: [(0, 2), (1, 3)]

import java.util.ArrayList;
import java.util.List;

public class Array {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) result.add(new int[]{i, j});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};
        for (int[] sub : findZeroSumSubarrays(arr))
            System.out.println("(" + sub[0] + ", " + sub[1] + ")");
    }
}
