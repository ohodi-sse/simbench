import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int int1 = Integer.parseInt(scanner.next());
        scanner.close();
        int x = 0;
        for (int i = 0; i <= 7; ++i) {
            if ((int)Math.floor(Math.pow(2.0, i)) > int1) {
                x = (int)Math.floor(Math.pow(2.0, i - 1));
                break;
            }
        }
        System.out.println(x);
    }
}