import java.util.HashSet;

public class Main {
    public static int maxCyclicSubstringSum(String S) {
        int n = S.length();
        String doubled = S + S; // simulate cyclic behavior
        
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {
            
            // Remove duplicates OR if window size exceeds n
            while (set.contains(doubled.charAt(right)) || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            // Add current character
            char ch = doubled.charAt(right);
            set.add(ch);
            currentSum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        String S = "abca";
        System.out.println(maxCyclicSubstringSum(S)); // Output: 6
    }
}
