import java.util.Scanner;

public class Main
{
    public static void main(final String[] array) throws Exception {
        for (int nextInt = new Scanner(System.in).nextInt(), i = 0; i < nextInt; ++i) {
            if (nextInt == Math.pow(2.0, i)) {
                System.out.println((int)Math.pow(2.0, i));
                break;
            }
            if (nextInt < Math.pow(2.0, i)) {
                System.out.println((int)Math.pow(2.0, i - 1));
                break;
            }
        }
    }
}