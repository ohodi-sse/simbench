public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        scanner.close();
        for (int i = 0; i < 8; ++i) {
            if (nextInt < Math.pow(2.0, i)) {
                System.out.println((int)Math.pow(2.0, i - 1));
                return;
            }
        }
    }
}