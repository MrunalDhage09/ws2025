import java.util.*;

public class Main {
    
    // Find leaders in the array
    public static List<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        // The rightmost element is always a leader
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);
        
        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }
        
        // Reverse to get leaders in original order
        Collections.reverse(leaders);
        return leaders;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Leaders: " + findLeaders(arr1));
        
        System.out.println();
        
        // Test case 2
        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Leaders: " + findLeaders(arr2));
        
        System.out.println();
    }
}
