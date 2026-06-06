import java.util.*;

public class StringWithBitwiseShifting {
    public void Bitwise(String str) {
        int len = str.length();

        for(int i = 0; i < (1 << len); i++) {
            String combination = "";

            for(int j = 0; j < len; j++) {
                if((i & (1 << j)) > 0) {
                    combination += str.charAt(j);
                }
            }

            System.out.println(combination);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = scan.nextLine();
        StringWithBitwiseShifting obj = new StringWithBitwiseShifting();
        obj.Bitwise(str);
        scan.close();
    }
}
