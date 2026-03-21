import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final String next = new Scanner(System.in).next();
        boolean b = false;
        int x = 0;
        final char[] array2 = new char[next.length()];
        for (int i = 0; i < next.length(); ++i) {
            array2[i] = next.charAt(i);
            if (array2[i] == 'R') {
                ++x;
                b = true;
            }
            if (array2[i] == 'S' && b) {
                break;
            }
        }
        System.out.println(x);
    }
}