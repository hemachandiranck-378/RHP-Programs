import java.util.Scanner;

public class Panagram {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scan.nextLine();

        int flag = 0;

        for (char ch : s.toCharArray()) {

            ch = Character.toLowerCase(ch);

            if (ch >= 'a' && ch <= 'z') {
                flag |= (1 << (ch - 'a'));
            }
        }

        if (flag == (1 << 26) - 1)
            System.out.println("The given string is pangram");
        else
            System.out.println("The given string is not pangram");

        scan.close();
    }
}