import java.util.*;

public class KarenAndCoffee {

    public static int[] solve(int[][] ranges, int n, int k) {
        int maxi = 200000;
        int[] different = new int[maxi + 2];

        for(int i = 0; i < n; i++) {
            int left = ranges[i][0];
            int right = ranges[i][1];

            different[left]++;
            different[right + 1]--;
        }

        int[] freq = new int[maxi + 1];

        for(int i = 1; i <= maxi; i++) 
            freq[i] = freq[i - 1] + different[i];

        int[] admissible = new int[maxi + 1];

        for(int i = 1; i <= maxi; i++) {
            if(freq[i] >= k) 
                admissible[i] = 1;
        }

        int[] pref = new int[maxi + 1];

        for(int i = 1; i <= maxi; i++) 
            pref[i] = pref[i - 1] + admissible[i];

        return pref;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int q = scan.nextInt();

        int[][] ranges = new int[n][2];

        for(int i = 0; i < n; i++) {
            ranges[i][0] = scan.nextInt();
            ranges[i][1] = scan.nextInt();
        }

        int[] pref = solve(ranges, n, k);

        while(q-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            System.out.println(pref[b] - pref[a - 1]);
        }
        scan.close();
    }

}
