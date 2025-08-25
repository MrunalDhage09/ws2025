import java.util.*;

public class UniquePermutations {
    
    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // sort to handle duplicates
        boolean[] used = new boolean[chars.length];
        backtrack(chars, used, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            // skip used characters
            if (used[i]) continue;

            // skip duplicates (important!)
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            // choose
            used[i] = true;
            current.append(chars[i]);

            // explore
            backtrack(chars, used, current, result);

            // undo (backtrack)
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    // Example runner
    public static void main(String[] args) {
        System.out.println(permuteUnique("abc"));  // [abc, acb, bac, bca, cab, cba]
        System.out.println(permuteUnique("aab"));  // [aab, aba, baa]
        System.out.println(permuteUnique("aaa"));  // [aaa]
        System.out.println(permuteUnique("a"));    // [a]
    }
}
