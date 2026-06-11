import java.util.*;

public class LongestCommonSubstring {
    public String longestCommonSubstring(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        int maxLen = 0;
        int end = 0;

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if(dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        end = i;
                    }
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        if(maxLen == 0) {
            return "";
        }
        return str1.substring(end - maxLen, end);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter first String: ");
        String str1 = scan.nextLine();
        System.out.print("Enter second String: ");
        String str2 = scan.nextLine();

        LongestCommonSubstring lss = new LongestCommonSubstring();
        String res = lss.longestCommonSubstring(str1, str2);

        System.out.println("The Longest Substring: " + res);
        scan.close();
    }
}
