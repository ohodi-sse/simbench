import java.util.Scanner;





public class Main
{
    public static int findMaxConsecutiveDays(final String s) {
        int n = 0;
        final char[] charArray = s.toCharArray();
        int n2 = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == 'R') {
                ++n2;
            }
            else {
                if (n2 > n) {
                    n = n2;
                }
                n2 = 0;
            }
        }
        if (n2 > n) {
            n = n2;
        }
        return n;
    }
    
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(findMaxConsecutiveDays(scanner.next()));
        scanner.close();
    }
}