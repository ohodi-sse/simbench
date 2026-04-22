import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final char[] charArray = new Scanner(System.in).nextLine().toCharArray();
        int n;
        int x = n = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == 'R') {
                ++n;
            }
            else {
                n = 0;
            }
            if (n > x) {
                x = n;
            }
        }
        System.out.println(x);
    }
}