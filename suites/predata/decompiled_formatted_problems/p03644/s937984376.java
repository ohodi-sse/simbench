import java.util.Scanner;





class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        int n = 0;
        int nextInt = scanner.nextInt();
        for (int i = 0; i < 32; ++i) {
            if (nextInt % 2 == 1) {
                n = i;
            }
            nextInt /= 2;
        }
        int x = 1;
        for (int j = 0; j < n; ++j) {
            x *= 2;
        }
        System.out.println(x);
    }
}