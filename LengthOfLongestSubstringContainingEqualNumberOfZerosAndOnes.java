import java.util.*;

public class LengthOfLongestSubstringContainingEqualNumberOfZerosAndOnes {

    public static int findMaxLen(String str) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);

        int maxLen = 0;
        int sum = 0;

        for(int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) == '1') ? 1 : -1;
            if(hm.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - hm.get(sum));
            }
            else {
                hm.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(findMaxLen(str));
        scan.close();
    }

}
