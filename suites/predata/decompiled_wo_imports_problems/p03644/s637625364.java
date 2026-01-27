public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        int n = 0;
        int n2 = 0;
        int i = 1;
        for (int j = 1; j <= nextInt; ++j) {
            for (int n3 = j; n3 % 2 == 0; n3 /= 2, ++n) {}
            if (n2 < n) {
                n2 = n;
                i = j;
            }
            n = 0;
        }
        System.out.print(i);
        scanner.close();
    }
}