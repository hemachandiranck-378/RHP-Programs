import java.util.*;

public class C_Sushi {

    public static int sushi(long[] A, long[] B, int n, int m) {
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0, answer = 0;

        while(i < n && j < m) {
            if(B[j] <= 2 * A[i]) {
                answer++;
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        long[] A = new long[n];
        long[] B = new long[m];

        for(int i = 0; i < n; i++) 
            A[i] = scan.nextLong();

        for(int i = 0; i < m; i++) 
            B[i] = scan.nextLong();

        System.out.println(sushi(A, B, n, m));
        scan.close();
    }

}
