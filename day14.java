import java.util.*;

public class SubstringsWithKDistinct {
    
    // Main function
    public static int countSubstringsExactlyK(String s, int k) {
        if (k > s.length()) return 0;
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    // Helper: count substrings with at most k distinct characters
    private static int countAtMostK(String s, int k) {
        int left = 0, result = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window if more than k distinct chars
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) freq.remove(leftChar);
                left++;
            }

            // Add number of substrings ending at right
            result += (right - left + 1);
        }

        return result;
    }

    // Test
    public static void main(String[] args) {
        System.out.println(countSubstringsExactlyK("pqpqs", 2));       // 7
        System.out.println(countSubstringsExactlyK("aabacbebebe", 3)); // 10
        System.out.println(countSubstringsExactlyK("a", 1));           // 1
        System.out.println(countSubstringsExactlyK("abc", 3));         // 1
        System.out.println(countSubstringsExactlyK("abc", 2));         // 2
    }
}
