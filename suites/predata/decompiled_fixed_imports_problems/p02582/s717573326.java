import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) {
        final long currentTimeMillis = System.currentTimeMillis();
        final Scanner scanner = new Scanner(System.in);
        try {
            final String s = new String();
            final char[] charArray = scanner.nextLine().toCharArray();
            int x = 0;
            for (int i = 0; i < 3; ++i) {
                int n = 0;
                for (int n2 = i; n2 < 3 && charArray[n2] == 'R'; ++n2) {
                    ++n;
                }
                if (x < n) {
                    x = n;
                }
            }
            System.out.println(x);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        finally {
            scanner.close();
        }
        final double n3 = (System.currentTimeMillis() - currentTimeMillis) / 1000.0;
    }
}