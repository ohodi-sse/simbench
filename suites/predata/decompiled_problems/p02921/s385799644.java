import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        scanner.close();
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            if (next.substring(i, i + 1).equals(next2.substring(i, i + 1))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}