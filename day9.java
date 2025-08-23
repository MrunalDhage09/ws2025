public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as initial prefix
        String prefix = strs[0];

        // Compare with each string
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    // Helper function to find common prefix of two strings
    private static String commonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

    // Test cases
    public static void main(String[] args) {
        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"apple", "ape", "april"},
            {""},
            {"alone"},
            {}
        };

        for (String[] test : testCases) {
            System.out.println("Input: " + java.util.Arrays.toString(test));
            System.out.println("Output: \"" + longestCommonPrefix(test) + "\"");
            System.out.println();
        }
    }
}
