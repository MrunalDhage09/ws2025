//Input: "a good   example"
//Output: "example good a"


public class ReverseWords {
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = n - 1;

        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            // Find the end of a word
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            int start = i + 1;

            // Append word to result
            if (result.length() > 0) {
                result.append(" ");
            }
            for (int j = start; j <= end; j++) {
                result.append(s.charAt(j));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println( reverseWords("the sky is blue");     
        System.out.println( reverseWords("  hello world  ");     
        System.out.println(reverseWords("a good   example");    
        System.out.println( reverseWords("    ") ;                
        System.out.println(reverseWords("word");                
    }
}
