public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int i = scanner.nextInt();
        scanner.close();
        int x = 0;
        int n;
        for (n = 1; i >= n; n *= 2) {
            if (i == n) {
                x = n;
            }
        }
        if (x == 0) {
            x = n / 2;
        }
        System.out.println(x);
    }
}