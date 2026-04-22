import java.util.Scanner;

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();
        final String nextLine2 = scanner.nextLine();
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (Character.valueOf(nextLine.charAt(i)) == Character.valueOf(nextLine2.charAt(i))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}