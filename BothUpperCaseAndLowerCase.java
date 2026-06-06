import java.util.Scanner;

public class BothUpperCaseAndLowerCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int flagL = 0;
        int flagU = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                flagL |= (1 << (ch - 'a'));
            }
            else if (Character.isUpperCase(ch)) {
                flagU |= (1 << (ch - 'A'));
            }
        }

        int allLetters = (1 << 26) - 1;

        if (flagL == allLetters && flagU == allLetters) {
            System.out.println("The given string is a pangram (Both upper and lower case)");
        } else {
            System.out.println("The given string is not a pangram (Both upper and lower case)");
        }

        sc.close();
    }
}
