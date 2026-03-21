import java.util.Scanner;





public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final String[] array2 = new String[3];
        final String[] array3 = new String[3];
        final String[] split = scanner.nextLine().split("");
        final String[] split2 = scanner.nextLine().split("");
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}